package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;
import com.go.jek.impl.pl.ParkingHandler;

public class Leave extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.LEAVE.getValue(), new Leave());
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

        return new Leave();
    }

    private void handle(Command command){

        try{
            int slotNum = Integer.parseInt(command.args.get(0));
            parkingHandler.markSlotEmpty(slotNum);
            System.out.println("Slot number " + command.args.get(0) + " is free");
        }catch(NumberFormatException e){
            System.out.println("Argument is not a number!");
        }

    }
}
