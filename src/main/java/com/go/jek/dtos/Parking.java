package com.go.jek.dtos;

import java.util.List;

public class Parking {

    private Integer parkingNum;
    private List<Floor> floors;


    public Parking(Integer parkingNum, List<Floor> floors){

        this.parkingNum = parkingNum;
        this.floors = floors;
    }

    public Integer getParkingNum() {
        return parkingNum;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
