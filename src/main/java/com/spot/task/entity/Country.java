package com.spot.task.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CARD_NO")
    private String countryName;

    @Column(name = "BAN_STATUS")
    private Boolean isBanned;

    public Country() {
    }

    public Country(String countryName, Boolean isBanned) {
        this.countryName = countryName;
        this.isBanned = isBanned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", isBanned=" + isBanned +
                '}';
    }
}