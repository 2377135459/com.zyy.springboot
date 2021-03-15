package com.springboot.demo.designMode.command;

//下一曲命令类
public class NextCommand implements Command {

    private Player player;

    public NextCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.next();
    }

}
