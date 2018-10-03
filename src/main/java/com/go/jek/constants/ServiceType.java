package com.go.jek.constants;

public enum ServiceType {

    File("file"), Console("console");

    private String value;

    public String getValue(){

        return this.value;
    }

    ServiceType(String value) {

        this.value = value;
    }
}
