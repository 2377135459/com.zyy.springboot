package com.springboot.demo.designMode.command;

//命令发送类
public class PlayerInvoker {

    private TurnOnCommand on;
    private TurnOffCommand off;
    private NextCommand next;

    public PlayerInvoker(TurnOnCommand on, TurnOffCommand off, NextCommand next) {
        this.on = on;
        this.off = off;
        this.next = next;
    }

    public void turnOn() {
        this.on.execute();
    }

    public void turnOff() {
        this.off.execute();
    }

    public void next() {
        this.next.execute();
    }
}
