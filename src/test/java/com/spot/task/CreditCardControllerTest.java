package com.spot.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spot.task.controller.CardController;
import com.spot.task.entity.CreditCard;
import com.spot.task.exception.CustomizedExceptionHandling;
import com.spot.task.model.CreditCardModel;
import com.spot.task.service.CreditCardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreditCardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CreditCardService creditCardService;

    @InjectMocks
    private CardController cardController;



    @BeforeEach
    public void setup() {
        // We would need this line if we would not use the MockitoExtension
        // MockitoAnnotations.initMocks(this);
        // Here we can't use @AutoConfigureJsonTesters because there isn't a Spring context
        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        mockMvc = MockMvcBuilders.standaloneSetup(cardController)
                .setControllerAdvice(new CustomizedExceptionHandling())
                .build();
    }

    @Test
    public void getCardInfo() throws Exception {
        // given
        CreditCardModel creditCardModel = new CreditCardModel("2525298212", "punyasloka", LocalDate.of(2021, 02, 12), "INDIA");
        when(creditCardService.getCardDetails(any())).thenReturn(creditCardModel);

        // when
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/cards/cardInfo?cardNo=1272727").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertThat(result.getResponse()).isNotNull();
    }


    @Test
    public void getAllCards() throws Exception {
        // given
        CreditCardModel creditCardModel = new CreditCardModel("2525298212", "punyasloka", LocalDate.of(2021, 02, 12), "INDIA");
        when(creditCardService.getAllCardDetails()).thenReturn(Arrays.asList(creditCardModel));

        // when
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/cards/allCardInfo").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertThat(result.getResponse()).isNotNull();
    }
}
