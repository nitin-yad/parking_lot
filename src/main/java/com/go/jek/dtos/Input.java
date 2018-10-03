package com.go.jek.dtos;

public class Input {

    private String type;
    private String fileLocation;

    public Input(String type, String fileLocation){

        this.type = type;
        this.fileLocation = fileLocation;
    }

    public String getType() {
        return type;
    }

    public String getFileLocation() {
        return fileLocation;
    }
}
