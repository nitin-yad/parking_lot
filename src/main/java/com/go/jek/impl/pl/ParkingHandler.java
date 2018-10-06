package com.go.jek.impl.pl;

import com.go.jek.dtos.Floor;
import com.go.jek.dtos.Parking;
import com.go.jek.dtos.Slot;
import com.go.jek.dtos.Vehicle;
import com.go.jek.impl.command.Park;

import java.util.*;

public class ParkingHandler {

    private static ParkingHandler parkingHandler = new ParkingHandler();

    private Parking parking = new Parking(1, new ArrayList<Floor>());
    private List<Slot> occupiedSlots = new LinkedList<Slot>();
    private Map<Integer, Boolean> slotMap = new HashMap<Integer, Boolean>();
    private Integer nextSlotToAllocate;
    private Integer parkingCapacity = 0;

    public static ParkingHandler getInstance(){

        return parkingHandler;
    }

    public void initialiseParkingSpace(Integer slotCount){

        // this method is called on create call
        Floor floor = new Floor(parking.getFloors().size()+1, new ArrayList<Slot>());
        int totalFloor = parking.getFloors().size();
        Floor lastFloor = totalFloor > 0 ? parking.getFloors().get(parking.getFloors().size() - 1) : null;
        int totalSlots = lastFloor != null ? lastFloor.getSlots().get(lastFloor.getSlots().size() -1).getSlotNum() : 0;
        for(int j =0; j< slotCount; j++){

            int slotId = totalSlots+j+1;
            Slot slot = new Slot(slotId, null);
            slotMap.put(slotId, false);
            floor.getSlots().add(slot);
        }
        parking.getFloors().add(floor);
        parkingCapacity = totalSlots + slotCount;
    }

    public void markSlotEmpty(Integer slotNum){

        // when someone leaves the slot
        List<Floor> floors = parking.getFloors();
        if(floors.size() == 0){
            System.out.println("No vehicle in this slot");
        }else{
            int temp = slotNum;
            int prev = slotNum;
            int count = 0;
            Floor floor = null;
            while(temp > 0){
                floor  = floors.get(count);
                prev = temp;
                temp -= floor.getSlots().size();
                count++;
            }
            if (floor != null) {
                for(Slot slot: floor.getSlots()){
                    prev--;
                    if(prev == 0){
                        if(slot.getParkedVehicle() != null){
                            occupiedSlots.remove(slot);
                            slot.setParkedVehicle(null);
                        }else{
                            System.out.println("Slot is not occupied");
                        }
                    }
                }
                slotMap.put(slotNum, false);
            }
        }
    }

    public void parkOnSlot(Integer slotNum, Vehicle vehicle){

        // when park is called
        List<Floor> floors = parking.getFloors();
        int temp = slotNum;
        int prev = slotNum;
        int count = 0;
        Floor floor = null;
        while(temp > 0){
            floor  = floors.get(count);
            prev = temp;
            temp -= floor.getSlots().size();
            count++;
        }
        if (floor != null) {
            for(Slot slot: floor.getSlots()){
                prev--;
                if(prev == 0){
                    slot.setParkedVehicle(vehicle);
                    occupiedSlots.add(slot);
                    break;
                }
            }
            slotMap.put(slotNum, true);
        }
    }

    public Integer getSlotToPark(){

        int slotNum = -1;
        if(parkingCapacity > 0){
            for(int i = 1; i <= parkingCapacity; i++ ){
                if(!slotMap.get(i)){
                    slotNum = i;
                    break;
                }
            }
        }
        return slotNum;
    }

    public List<Slot> getOccupiedSlotDetails(){

        return new LinkedList<Slot>(occupiedSlots);
    }

    public Integer getParkingCapacity(){

        return parkingCapacity;
    }

}
