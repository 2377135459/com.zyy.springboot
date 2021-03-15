package com.springboot.demo.designMode.command;

//关闭命令类
public class TurnOffCommand implements Command {

    private Player player;

    public TurnOffCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.turnOff();
    }

}
