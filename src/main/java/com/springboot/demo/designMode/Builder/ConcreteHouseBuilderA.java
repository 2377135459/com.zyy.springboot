package com.springboot.demo.designMode.Builder;


public class ConcreteHouseBuilderA extends HouseBuilder {
    private House house;

    public ConcreteHouseBuilderA() {
        house = new House();
    }

    @Override
    public void BuildRoom(int roomNo) {
        //建房子
        house.roomNumber++;
    }

    @Override
    public void BuildDoor(int room1, int room2) {
        // 建门
        house.doorNumber++;
    }

    @Override
    public House getHouse() {
        return house;
    }
}
