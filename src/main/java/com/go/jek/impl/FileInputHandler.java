package com.go.jek.impl;

import com.go.jek.api.InputHandler;
import com.go.jek.constants.AppConstants;
import com.go.jek.constants.ServiceType;
import com.go.jek.dtos.Input;

import java.io.*;

public class FileInputHandler extends InputHandler {

    static{

        InputProcessor.getInstance().registerInputHandler(ServiceType.File.getValue(), new FileInputHandler());
    }

    public Boolean isInputValid() {

        // validate input file path
        return true;
    }

    public void processInput(Input input) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(input.getFileLocation())));
            String command;
            while((command = br.readLine()) != null){
                if(AppConstants.EXIT.equals(command)){
                    System.exit(0);
                }else{
                    CommandProcessor.getInstance().handleRaw(command);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
