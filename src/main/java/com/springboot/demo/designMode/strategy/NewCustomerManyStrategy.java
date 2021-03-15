package com.springboot.demo.designMode.strategy;


// 新客户大批量
public class NewCustomerManyStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {

        System.out.println("新客户大批量，打九折");
        return standardPrice * 0.9;
    }

}
