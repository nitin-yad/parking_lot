package com.go.jek.impl;

import com.go.jek.api.InputHandler;
import com.go.jek.constants.ServiceType;

public class FileInputHandler implements InputHandler {

    static{

        InputProcessor inputProcessor = InputProcessor.getInstance();
        inputProcessor.registerService(ServiceType.File.getValue(), new FileInputHandler());
    }

    public Boolean isInputValid() {

        // validate input file path
        return true;
    }

    public void processInput() {

        System.out.println("inside file handler!");
    }
}
