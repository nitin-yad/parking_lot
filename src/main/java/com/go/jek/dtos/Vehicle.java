package com.go.jek.dtos;

public class Vehicle {

    private String registrationNum;
    private String color;
    private Person owner;

    public Vehicle(String registrationNum, String color, Person owner){

        this.registrationNum = registrationNum;
        this.color = color;
        this.owner = owner;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public String getColor() {
        return color;
    }

    public Person getOwner() {
        return owner;
    }
}
