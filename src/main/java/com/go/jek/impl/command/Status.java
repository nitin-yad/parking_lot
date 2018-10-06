package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.dtos.Slot;
import com.go.jek.dtos.Vehicle;
import com.go.jek.impl.CommandProcessor;
import com.go.jek.impl.pl.ParkingHandler;

import java.util.List;

public class Status extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.STATUS.getValue(), new Status());
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

        return new Status();
    }

    private void handle(Command command){

        List<Slot> occupiedSlots = parkingHandler.getOccupiedSlotDetails();
        System.out.println("Slot No.\t\t\tRegistration No\t\t\tColour");
        for(Slot slot : occupiedSlots){

            Vehicle vehicle = slot.getParkedVehicle();
            System.out.println(slot.getSlotNum()+"\t\t\t\t"+vehicle.getRegistrationNum()+"\t\t\t\t"+vehicle.getColor());
        }
    }
}
