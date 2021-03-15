package com.springboot.demo.designMode.strategy;

public class Client {

    public static void main(String[] args) {

        Strategy s1 = new OldCustomerManyStrategy();
        Context ctx = new Context(s1); //通过构造方法注入策略

        ctx.getPrice(1000);
    }

}