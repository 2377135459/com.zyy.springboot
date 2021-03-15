package com.springboot.demo.designMode.strategy;


// 老客户小批量
public class OldCustomerFewStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {

        System.out.println("老客户小批量，打八折");
        return standardPrice * 0.8;
    }

}