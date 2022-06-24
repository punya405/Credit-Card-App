package com.spot.task.model;

import java.time.LocalDate;

public class CreditCardModel {

    private String cardNo;
    private String cardHolderName;
    private LocalDate validity;
    private String issuerCountry;

    public CreditCardModel() {
    }

    public CreditCardModel(String cardNo, String cardHolderName, LocalDate validity, String issuerCountry) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.validity = validity;
        this.issuerCountry = issuerCountry;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }
}
