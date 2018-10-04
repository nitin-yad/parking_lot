package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;

public class Leave extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.LEAVE.getValue(), new Leave());
    }

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }
    }

    public Command createNew(){

        return new Leave();
    }

    private void handle(Command command){

        System.out.println(command.command);
    }
}
