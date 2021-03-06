package Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Commands {
    private static Map<String, Commandable> commands = new TreeMap<>();
    private static ArrayList<String> history = new ArrayList<>();
    public static ArrayList<String> getHistory() {
        return history;
    }

    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    /**
     * creates list of commands
     *
     * @param commands
     */
    public void regist(Commandable... commands) {
        for (Commandable command : commands)
            Commands.commands.put(command.getName(), command);
    }

    /**
     * add used commands to history list
     *
     * @param commandName
     */
    public void addToHistory(String commandName){
        if (commandName.equals("history") == false)
            history.add(commandName);
    }

    /**
     * execute certain command
     * you can review command list by typing 'help'
     *
     * @param commandName
     */
    public void executeCommand(String commandName) {
        String[] nameAndArgument = commandName.split(" ");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        commands.get(nameAndArgument[0]).execute(null);
                        this.addToHistory(nameAndArgument[0]);
                    }
                } catch (Exception e) {
                    try {
                        String s = nameAndArgument[2];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            commands.get(nameAndArgument[0]).execute(nameAndArgument[1]);
                            this.addToHistory(nameAndArgument[0]);
                        } catch (IndexOutOfBoundsException | FileNotFoundException e2) {
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        }
                    }
                }
            }
        }
    }
}