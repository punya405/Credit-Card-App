package com.spot.task.service;

import com.spot.task.entity.Country;
import com.spot.task.entity.CreditCard;
import com.spot.task.exception.CardNotFoundException;
import com.spot.task.exception.DuplicateCard;
import com.spot.task.exception.InvalidCarddetailException;
import com.spot.task.mapper.CreditCardMapper;
import com.spot.task.model.CreditCardModel;
import com.spot.task.repository.CountryRepo;
import com.spot.task.repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepo creditCardRepo;

    @Autowired
    private CountryRepo countryRepo;

    private static List<Country> bannedCountry = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<Country> list = countryRepo.findAll();
        bannedCountry = list.stream().filter(country -> country.getBanned()).collect(Collectors.toList());
    }

    public CreditCardModel getCardDetails(String cardNo) {
        Optional<CreditCard> creditCardOpt = creditCardRepo.findByCardNo(cardNo);
        if (creditCardOpt.isPresent()) {
            CreditCard creditCard = creditCardOpt.get();
            return CreditCardMapper.constructCreditCardToModel(creditCard);
        }
        throw new CardNotFoundException("Card Not found");
    }

    public List<CreditCardModel> getAllCardDetails() {
        List<CreditCard> creditCards = creditCardRepo.findAll();
        if (!creditCards.isEmpty()) {
            return creditCards.stream().map(creditCard -> CreditCardMapper.constructCreditCardToModel(creditCard))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public CreditCardModel saveCard(CreditCardModel cardModel) {
        validateCardDetails(cardModel);
        CreditCard creditCard = CreditCardMapper.constructCreditCardModelToEntity(cardModel);
        if (nonNull(creditCard)) {
            creditCard = creditCardRepo.save(creditCard);
        }
        return CreditCardMapper.constructCreditCardToModel(creditCard);
    }

    public List<CreditCardModel> bulkSave(List<CreditCardModel> cardModels) {
        cardModels.stream().peek(cardModel -> validateCardDetails(cardModel));
        List<CreditCard> creditCard = CreditCardMapper.constructCreditCardModelListToEntityList(cardModels);
        if (nonNull(creditCard)) {
            creditCardRepo.saveAll(creditCard);
        }
        return cardModels;
    }

    private void validateCardDetails(CreditCardModel cardModel) {
        if (nonNull(cardModel)) {
            String cardNo = cardModel.getCardNo();
            if (nonNull(cardNo) && (cardNo.trim().length() != 10)) {
                throw new InvalidCarddetailException("Card no is invalid | card no should have 10 digit length");
            }

            if (nonNull(cardNo)) {
                Optional<CreditCard> creditCardOpt = creditCardRepo.findByCardNo(cardNo);
                if (creditCardOpt.isPresent()) {
                    throw new DuplicateCard("Card no is already present");
                }
            }

            String issuerCountry = cardModel.getIssuerCountry();
            if (nonNull(issuerCountry) && bannedCountry.contains(issuerCountry)) {
                throw new InvalidCarddetailException("Card Issue Country is banned");
            }
        }
    }

}
