package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.dtos.Vehicle;
import com.go.jek.impl.CommandProcessor;
import com.go.jek.impl.pl.ParkingHandler;

public class Park extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.PARK.getValue(), new Park());
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

        return new Park();
    }

    private void handle(Command command){

        String regNum = command.args.get(0);
        String color = command.args.get(1);
        Vehicle vehicle = new Vehicle(regNum, color, null);
        int slotNum = parkingHandler.getSlotToPark();
        if(slotNum == -1){
            System.out.println("Sorry, parking lot is full");
        }else{
            parkingHandler.parkOnSlot(slotNum, vehicle);
            System.out.println("Allocated slot number: "+ slotNum);
        }
    }
}
