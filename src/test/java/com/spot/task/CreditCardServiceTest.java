package com.spot.task;


import com.spot.task.entity.CreditCard;
import com.spot.task.model.CreditCardModel;
import com.spot.task.repository.CreditCardRepo;
import com.spot.task.service.CreditCardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceTest {

    @Mock
    private CreditCardRepo creditCardRepo;

    @InjectMocks
    private CreditCardService creditCardService;

    @Test
    public void getCardDetails() {
        // given
        Optional<CreditCard> creditCardOpt = Optional.of(new CreditCard("2525298212", "punyasloka", LocalDate.of(2021, 02, 12), "INDIA"));
        when(creditCardRepo.findByCardNo(any())).thenReturn(creditCardOpt);

        CreditCardModel creditCardModel = creditCardService.getCardDetails("12228282822");
        assertThat(creditCardModel).isNotNull();

    }

    @Test
    public void getAllCards() {
        // given
        CreditCard creditCard = new CreditCard("2525298212", "punyasloka", LocalDate.of(2021, 02, 12), "INDIA");
        when(creditCardRepo.findAll()).thenReturn(Arrays.asList(creditCard));

        List<CreditCardModel> creditCardModels = creditCardService.getAllCardDetails();
        assertThat(creditCardModels).isNotNull();

    }


}
