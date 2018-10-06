package com.go.jek.dtos;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private Integer floorNum;
    private List<Slot> slots;

    public Floor(Integer floorNum, List<Slot> slots){

        this.floorNum = floorNum;
        this.slots = slots;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
