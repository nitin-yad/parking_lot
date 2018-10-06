package com.go.jek.impl.command;

import com.go.jek.constants.CommandType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Command {

    private static Map<String, Integer> validationMap = new HashMap<String, Integer>();
    static{

        /**
         * this could be populated from config file or database
         */
        validationMap.put(CommandType.CREATE.getValue(), 1);
        validationMap.put(CommandType.PARK.getValue(), 2);
        validationMap.put(CommandType.LEAVE.getValue(), 1);
        validationMap.put(CommandType.STATUS.getValue(), 0);
        validationMap.put(CommandType.SEARCH_RN_WITH_COLOR.getValue(), 1);
        validationMap.put(CommandType.SEARCH_SN_WITH_COLOR.getValue(), 1);
        validationMap.put(CommandType.SEARCH_SN_WITH_RN.getValue(), 1);
    }

    String command;
    List<String> args;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public Boolean isValidCommand(){

        return this.args.size() >= validationMap.get(this.command);
    }

    public abstract void processCommand();

    public abstract Command createNew();

}
