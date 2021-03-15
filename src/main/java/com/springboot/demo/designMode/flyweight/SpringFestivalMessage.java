package com.springboot.demo.designMode.flyweight;

public class SpringFestivalMessage extends SMS {
    @Override
    public void sendMessage(String personName) {
        System.out.println("过年好" + personName + "!");
    }
}