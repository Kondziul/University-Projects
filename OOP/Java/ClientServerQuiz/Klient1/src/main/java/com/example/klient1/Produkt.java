package com.example.klient1;

import java.io.Serializable;

public class Produkt implements Serializable {
    private String nazwa;

    public Produkt(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProdukt() {
        return nazwa;
    }
}
