package com.springboot.demo.designMode.strategy;


/**
 * @author Ni Shengwu
 * @Description 负责和具体的策略交互，具体的算法和直接的客户端分离。
 */
public class Context {

    private Strategy strategy;

    // 通过构造方法注入具体的策略，如果用Spring，就可以直接使用@Resource来注入了
    public Context(Strategy strategy) {
        super();
        this.strategy = strategy;
    }

    public void getPrice(double standardPrice) {
        System.out.println("报价为：" + strategy.getPrice(standardPrice));
    }

}