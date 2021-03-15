package com.springboot.demo.designMode.command;

//测试类
public class Text {

    public static void main(String[] args) {

        Player player = new Player();
        TurnOnCommand on = new TurnOnCommand(player);
        TurnOffCommand off = new TurnOffCommand(player);
        NextCommand next = new NextCommand(player);

        PlayerInvoker invoker = new PlayerInvoker(on, off, next);

        invoker.turnOn();
        invoker.turnOff();
        invoker.next();
    }
}
