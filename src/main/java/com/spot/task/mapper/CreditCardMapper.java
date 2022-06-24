package com.spot.task.mapper;

import com.spot.task.entity.CreditCard;
import com.spot.task.model.CreditCardModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CreditCardMapper {

    public static CreditCardModel constructCreditCardToModel(CreditCard creditCard){
        if(Objects.nonNull(creditCard)){
            return new CreditCardModel(creditCard.getCardNo(),
                    creditCard.getCardHolderName(),creditCard.getValidity(),
                    creditCard.getIssuerCountry());
        }
        return null;
    }

    public static CreditCard constructCreditCardModelToEntity(CreditCardModel creditCardModel){
        if(Objects.nonNull(creditCardModel)){
            return new CreditCard(creditCardModel.getCardNo(),
                    creditCardModel.getCardHolderName(),creditCardModel.getValidity(),
                    creditCardModel.getIssuerCountry());
        }
        return null;
    }

    public static List<CreditCard> constructCreditCardModelListToEntityList(List<CreditCardModel>  creditCardModels){
        if(!creditCardModels.isEmpty()){
            return creditCardModels.stream().map(CreditCardMapper::constructCreditCardModelToEntity)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
