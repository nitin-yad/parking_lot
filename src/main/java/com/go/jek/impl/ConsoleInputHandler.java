package com.go.jek.impl;

import com.go.jek.api.InputHandler;
import com.go.jek.constants.AppConstants;
import com.go.jek.constants.ServiceType;
import com.go.jek.dtos.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputHandler extends InputHandler {

    static{

        InputProcessor.getInstance().registerInputHandler(ServiceType.Console.getValue(), new ConsoleInputHandler());
    }

    public Boolean isInputValid() {

        return true;
    }

    public void processInput(Input input) {

        try{

            System.out.println("Here is your interactive console, please input command-");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String command = br.readLine();
                if(AppConstants.EXIT.equals(command)){
                    System.exit(0);
                }else{
                    CommandProcessor.getInstance().handleRaw(command);
                }
            }
        }catch(IOException e){
            System.out.println("IOException occurred while reading commands!");
        }
    }

    public static String getInputType(){

        return ServiceType.Console.getValue();
    }
}
