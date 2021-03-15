package com.springboot.demo.designMode.flyweight;

public class BirthdayMessage extends SMS {
    @Override
    public void sendMessage(String personName) {
        System.out.println("生日快乐" + personName + "!");
    }
}