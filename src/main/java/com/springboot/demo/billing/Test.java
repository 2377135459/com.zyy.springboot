package com.springboot.demo.billing;

import com.springboot.demo.billing.billingInterface.IBilling;
import com.springboot.demo.billing.impl.IBillingImpl;

public class Test {
    public static void main(String[] args) {
        IBilling billing = new IBillingImpl();
        String s = billing.fristMonthBilling(1, 2000.0, 0.5);
        System.out.println(s);
    }
}
