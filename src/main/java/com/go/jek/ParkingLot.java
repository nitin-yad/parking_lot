package com.go.jek;

import com.go.jek.constants.ServiceType;
import com.go.jek.dtos.Input;
import com.go.jek.impl.InputProcessor;

public class ParkingLot {

    public static void main(String[] args){

        InputProcessor inputProcessor = InputProcessor.getInstance();
        Input input;
        if(args.length > 0){
            input = new Input(ServiceType.File.getValue(), args[0]);
        }else{
            input = new Input(ServiceType.Console.getValue(), null);
        }
        inputProcessor.initialiseHandler(input);
    }
}
