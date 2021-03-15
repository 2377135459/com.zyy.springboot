package com.springboot.demo.designMode.strategy;


// 新客户小批量
public class NewCustomerFewStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {

        System.out.println("新客户小批量，不打折");
        return standardPrice;
    }

}
