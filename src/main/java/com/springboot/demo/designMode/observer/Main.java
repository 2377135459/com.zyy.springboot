package com.springboot.demo.designMode.observer;


public class Main {

    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        //添加两个观察者
        generator.addObserver(new DigitObserver());
        generator.addObserver(new GraphObserver());

        generator.execute();

    }

}
