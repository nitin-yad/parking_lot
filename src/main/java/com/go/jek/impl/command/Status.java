package com.go.jek.impl.command;

public class Status extends Command {

    public void processCommand() {

        if(this.isValidCommand()){
            handle(this);
        }
    }

    public Command createNew(){

        return new Status();
    }

    private void handle(Command command){

        System.out.println(command.command);
    }
}
