package com.go.jek.impl;

import com.go.jek.api.InputHandler;
import com.go.jek.dtos.Input;

import java.util.HashMap;
import java.util.Map;

public class InputProcessor {

    private static InputProcessor inputProcessor = new InputProcessor();
    private Map<String, InputHandler> services = new HashMap<String, InputHandler>();

    private InputProcessor(){

    }

    static {

        try {
            Class.forName(ConsoleInputHandler.class.getName());
            Class.forName(FileInputHandler.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static InputProcessor getInstance(){

        return inputProcessor;
    }

    public void registerInputHandler(String type, InputHandler inputHandler){

        services.put(type, inputHandler);
    }

    public InputHandler getInputHandler(String inputType){

        return services.get(inputType);
    }

    public void initialiseHandler(Input input){

        InputHandler inputHandler = getInputHandler(input.getType());
        if(inputHandler.isInputValid()){
            inputHandler.processInput(input);
        }else{
            System.out.println("Invalid input for the input type: " + input.getType());
        }

    }
}
