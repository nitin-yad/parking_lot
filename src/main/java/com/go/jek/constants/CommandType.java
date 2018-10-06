package com.go.jek.constants;

public enum CommandType {


    PARK("park"), CREATE("create_parking_lot"), LEAVE("leave"), STATUS("status"), SEARCH_RN_WITH_COLOR("registration_numbers_for_cars_with_colour"),
    SEARCH_SN_WITH_COLOR("slot_numbers_for_cars_with_colour"), SEARCH_SN_WITH_RN("slot_number_for_registration_number");

    private String value;

    public String getValue(){

        return this.value;
    }

    CommandType(String value) {

        this.value = value;
    }
}
