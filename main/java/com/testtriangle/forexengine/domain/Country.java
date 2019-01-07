package com.testtriangle.forexengine.domain;

public class Country {

    private String countryName, currencyName;
    private Double value;

    public Country(String countryName, String currencyName, Double value) {
        this.countryName = countryName;
        this.currencyName = currencyName;
        this.value = value;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Double getValue() {
        return value;
    }
}
