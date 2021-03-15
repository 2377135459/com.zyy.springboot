package com.springboot.demo.designMode.docorator;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("把大象装冰箱里面");
    }
}
