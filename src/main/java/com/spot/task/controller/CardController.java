package com.spot.task.controller;

import com.spot.task.model.CreditCardModel;
import com.spot.task.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CreditCardService creditCardService;

    @RequestMapping("/cardInfo")
    public ResponseEntity<CreditCardModel> getCreditCardDetails(@RequestParam("cardNo") String cardNo) {
       CreditCardModel creditCardModel = creditCardService.getCardDetails(cardNo);
        return ResponseEntity.ok(creditCardModel);
    }

    @RequestMapping("/allCardInfo")
    public ResponseEntity<List<CreditCardModel>> allCards() {
        List<CreditCardModel> creditCardModel = creditCardService.getAllCardDetails();
        return ResponseEntity.ok(creditCardModel);
    }

    @PostMapping("/save")
    public ResponseEntity<CreditCardModel> saveCard(@RequestBody CreditCardModel creditCardModel) {
        CreditCardModel creditCardModelResponse = creditCardService.saveCard(creditCardModel);
        return ResponseEntity.ok(creditCardModelResponse);
    }

    @PostMapping("/bulk/save")
    public ResponseEntity<List<CreditCardModel>> bulkSave(@RequestBody List<CreditCardModel> creditCardModels) {
        List<CreditCardModel> creditCardModelResponse = creditCardService.bulkSave(creditCardModels);
        return ResponseEntity.ok(creditCardModelResponse);
    }
}
