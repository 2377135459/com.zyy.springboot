package com.springboot.demo.designMode.strategy;

// 老客户大批量
public class OldCustomerManyStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {

        System.out.println("老客户大批量，打八折");
        return standardPrice * 0.7;
    }

}
