package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;

public class SearchRNWithColor extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.SEARCH_RN_WITH_COLOR.getValue(), new SearchRNWithColor());
    }

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }
    }

    public Command createNew(){

        return new SearchRNWithColor();
    }

    private void handle(Command command){

        System.out.println(command.command);
    }
}
