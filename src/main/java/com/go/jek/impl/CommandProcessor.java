package com.go.jek.impl;

import com.go.jek.impl.command.*;

import java.util.*;

public class CommandProcessor {

    private static CommandProcessor commandProcessor = null;
    private Map<String, Command> commandServices = new HashMap<String, Command>();
    private static Object lock = new Object();
    private CommandProcessor(){

    }

    static {

        try {
            Class.forName(Create.class.getName());
            Class.forName(Park.class.getName());
            Class.forName(Leave.class.getName());
            Class.forName(Status.class.getName());
            Class.forName(SearchRNWithColor.class.getName());
            Class.forName(SearchSNWithColor.class.getName());
            Class.forName(SearchSNWithRN.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static CommandProcessor getInstance(){

        if(null == commandProcessor){
            synchronized (lock){
                if(null == commandProcessor){
                    commandProcessor = new CommandProcessor();
                }
            }
        }
        return commandProcessor;
    }

    public Command getCommand(String commandName){

        return commandServices.get(commandName);
    }

    public void registerCommand(String type, Command command){

        commandServices.put(type, command);
    }

    public void handleRaw(String commandStr){

        Command command = convertFromRaw(commandStr);
        if(null != command){
            command.processCommand();
        }else{
            System.out.println("Invalid command!");
        }
    }

    private Command convertFromRaw(String str){

        Command newCommand = null;
        if(str.trim().length() > 0){

            String[] strings = str.split(" ");
            List<String> args = new ArrayList<String>(Arrays.asList(strings).subList(1, strings.length));
            String commandName = strings[0];
            Command command = getCommand(commandName);
            if(null != command){
                newCommand = command.createNew();
                newCommand.setCommand(strings[0]);
                newCommand.setArgs(args);
            }
        }
        return newCommand;
    }
}
