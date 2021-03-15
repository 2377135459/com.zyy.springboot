package com.springboot.demo.designMode.command;

//打开命令类
public class TurnOnCommand implements Command {

    private Player player;

    public TurnOnCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.turnOn();
    }

}
