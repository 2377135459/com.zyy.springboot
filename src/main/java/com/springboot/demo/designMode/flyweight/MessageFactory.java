package com.springboot.demo.designMode.flyweight;

import java.util.ArrayList;
import java.util.List;

//享元工厂
public class MessageFactory {
    private List<SMS> pool = new ArrayList();

    public MessageFactory() {
        pool.add(new SpringFestivalMessage());
        pool.add(new BirthdayMessage());
    }

    //getFlyweight
    public SMS getMessage(String key) {
        if ("SpringFestival".equalsIgnoreCase(key)) {
            return pool.get(0);
        } else {
            return pool.get(1);
        }
    }
}
