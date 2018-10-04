package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;

import java.util.ArrayList;
import java.util.List;

public class Create extends Command{

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.CREATE.getValue(), new Create());
    }

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }
    }

    public Command createNew(){

        return new Create();
    }

    private void handle(Command command){

        System.out.println(command.command);
    }
}
