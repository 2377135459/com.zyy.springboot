package com.springboot.demo.designMode.flyweight;

public class Test {
    public static void main(String[] args) {
        MessageFactory mf = new MessageFactory();
        SMS sms = mf.getMessage("SpringFestival");
        sms.sendMessage("张三");
        sms.sendMessage("李四");
        sms = mf.getMessage("Birthday");
        sms.sendMessage("张三");
        sms.sendMessage("李四");
    }
}
