package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;
import com.go.jek.impl.pl.ParkingHandler;

public class Create extends Command{

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.CREATE.getValue(), new Create());
    }

    ParkingHandler parkingHandler = ParkingHandler.getInstance();

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }else{
            System.out.println("Arguments are not proper!");
        }
    }

    public Command createNew(){

        return new Create();
    }

    private void handle(Command command){

        try{
            int slotCount = Integer.parseInt(command.args.get(0));
            parkingHandler.initialiseParkingSpace(slotCount);
            System.out.println("Created a parking lot with " + slotCount +" slots");
        }catch (NumberFormatException e){
            System.out.println("Argument is not a number!");
        }
    }
}
