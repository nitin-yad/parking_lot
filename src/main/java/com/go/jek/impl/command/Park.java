package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;

public class Park extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.PARK.getValue(), new Park());
    }

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }
    }

    public Command createNew(){

        return new Park();
    }

    private void handle(Command command){

        System.out.println(command.command);
    }
}
