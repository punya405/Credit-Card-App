package com.spot.task.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CreditCard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CARD_NO")
    private String cardNo;

    @Column(name = "CARD_HOLDER_NAME")
    private String cardHolderName;

    @Column(name = "VALIDITY")
    private LocalDate validity;

    @Column(name = "ISSUER_COUNTRY")
    private String issuerCountry;

    public CreditCard() {
    }

    public CreditCard(String cardNo, String cardHolderName, LocalDate validity, String issuerCountry) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.validity = validity;
        this.issuerCountry = issuerCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", validity=" + validity +
                ", issuerCountry='" + issuerCountry + '\'' +
                '}';
    }
}