package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;
import com.go.jek.impl.CommandProcessor;

public class SearchSNWithRN extends Command {

    static {
        CommandProcessor.getInstance().registerCommand(CommandType.SEARCH_SN_WITH_RN.getValue(), new SearchSNWithRN());
    }

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }
    }

    public Command createNew(){

        return new SearchSNWithRN();
    }

    private void handle(Command command){

        System.out.println(command.command);
    }
}
