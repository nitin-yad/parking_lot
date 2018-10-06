package com.go.jek.dtos;

public class Slot {

    private Integer slotNum;
    private Vehicle parkedVehicle;

    public Slot(Integer slotNum, Vehicle parkedVehicle){

        this.slotNum = slotNum;
        this.parkedVehicle = parkedVehicle;
    }

    public Integer getSlotNum() {
        return slotNum;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }
}
