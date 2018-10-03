package com.go.jek.impl;

import com.go.jek.api.InputHandler;
import com.go.jek.dtos.Input;

import java.util.HashMap;
import java.util.Map;

public class InputProcessor {

    private static InputProcessor inputProcessor = new InputProcessor();
    private Map<String, InputHandler> services = new HashMap<String, InputHandler>();

    static {

        try {
            System.out.println("Registering service: " + Class.forName(ConsoleInputHandler.class.getName()));
            System.out.println("Registering service: " + Class.forName(FileInputHandler.class.getName()));
            System.out.println("Services are successfully registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static InputProcessor getInstance(){

        return inputProcessor;
    }

    public void registerService(String type, InputHandler inputHandler){

        services.put(type, inputHandler);
    }

    public InputHandler getServiceOfType(String type){

        return services.get(type);
    }

    public void initialiseHandler(Input input){

        InputHandler inputHandler = getServiceOfType(input.getType());
        if(inputHandler.isInputValid()){
            inputHandler.processInput();
        }else{
            System.out.println("Invalid input for the input type: " + input.getType());
        }

    }

}
