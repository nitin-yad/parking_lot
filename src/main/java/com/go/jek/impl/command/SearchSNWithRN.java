package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.dtos.Slot;
import com.go.jek.dtos.Vehicle;
import com.go.jek.impl.CommandProcessor;
import com.go.jek.impl.pl.ParkingHandler;

import java.util.List;

public class SearchSNWithRN extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.SEARCH_SN_WITH_RN.getValue(), new SearchSNWithRN());
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

        return new SearchSNWithRN();
    }

    private void handle(Command command){

        String regNum = command.args.get(0);
        List<Slot> occupiedSlots = parkingHandler.getOccupiedSlotDetails();
        StringBuilder sb = new StringBuilder();
        for(Slot slot : occupiedSlots){

            Vehicle vehicle = slot.getParkedVehicle();
            if(regNum.equalsIgnoreCase(vehicle.getRegistrationNum())){
                sb.append(slot.getSlotNum()).append(", ");
            }
        }
        String str = sb.toString();
        if(str.length() > 0){
            System.out.println(str.substring(0, str.length()-2));
        }else{
            System.out.println("Not found");
        }
    }
}
