package com.testtriangle.forexengine.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "forex")
public class Forex {

    @Id
    private ObjectId id;

    private Country country1, country2;

    public Forex(Country country1, Country country2) {
        this.country1 = country1;
        this.country2 = country2;
    }

    public String getId() {
        return id.toHexString();
    }

    public Country getCountry1() {
        return country1;
    }

    public Country getCountry2() {
        return country2;
    }
}
