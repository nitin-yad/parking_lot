package com.go.jek;

import com.go.jek.constants.AppConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingLot {

    public static void main(String[] args){

        if(args.length > 0){
            handleFileInput(args[0]);
        }else{
            provideInteractiveConsole();
        }
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String command = br.readLine();
                if(AppConstants.EXIT.equals(command)){
                    System.exit(0);
                }else{
                    // validate & process command
                    System.out.println(command);
                }
            }
        }catch(IOException e){
            System.out.println("IOException occurred while reading commands!");
        }
    }
}
