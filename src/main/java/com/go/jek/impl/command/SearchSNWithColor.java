package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.dtos.Slot;
import com.go.jek.dtos.Vehicle;
import com.go.jek.impl.CommandProcessor;
import com.go.jek.impl.pl.ParkingHandler;

import java.util.List;

public class SearchSNWithColor extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.SEARCH_SN_WITH_COLOR.getValue(), new SearchSNWithColor());
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

        return new SearchSNWithColor();
    }

    private void handle(Command command){

        String color = command.args.get(0);
        List<Slot> occupiedSlots = parkingHandler.getOccupiedSlotDetails();
        StringBuilder sb = new StringBuilder();
        for(Slot slot : occupiedSlots){

            Vehicle vehicle = slot.getParkedVehicle();
            if(color.equalsIgnoreCase(vehicle.getColor())){
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
