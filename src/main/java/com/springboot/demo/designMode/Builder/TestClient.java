package com.springboot.demo.designMode.Builder;

/*
 *  A test client to create a house
 *  but we do not know how the room and door be created
 */
public class TestClient {
    public TestClient() {
    }

    public static void main(String[] args) {
        //实例化房子设施
        House myHouse = new House();
        //实例化建房子的实施者
        ConcreteHouseBuilderA myHouseBuilder = new ConcreteHouseBuilderA();
        //实例化建房子得调用指挥者
        HouseDirector myHouseDirector = new HouseDirector();
        //指挥者指挥某一个实施者建造房子
        myHouseDirector.CreateHouse(myHouseBuilder);
        //房子设施被实施者建造出来
        myHouse = myHouseBuilder.getHouse();

        System.out.println("My house has room :" + myHouse.getRoomNumber());
        System.out.println("My house has door :" + myHouse.getDoorNumber());
    }
}