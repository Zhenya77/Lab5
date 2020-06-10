package Commands;

import Controller.CommandWithObject;
import Controller.Commandable;
import Controller.Commands;
import Controller.DragonCollection;
import Dragon.Dragonborn;
import Utilites.ReaderFromFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Execute_script implements Commandable {
    String name = "execute_script";
    DragonCollection collection = new DragonCollection();
    ReaderFromFile reader = new ReaderFromFile();
    Commands invoker = new Commands();
    static private HashMap scripts = new HashMap();


    @Override
    public void execute(Object arg) {
        scripts.put((String) arg, 1);
        try {
            String data = reader.readFromFile((String) arg);
            Commands command = new Commands();
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                for (int i = 0; i < commands.length; i++) {
                    boolean isValidScript = true;
                    if (!(commands[i].equals(""))) {
                        String[] commandAndArg = commands[i].split(" ");
                        if (commandAndArg[0].equals("execute_script")) {
                            if (scripts.get(commandAndArg[1]) == null)
                                scripts.put(commandAndArg[1], 1);
                            else isValidScript = false;
                        }
                        try {
                            CommandWithObject commandWithObject = (CommandWithObject) invoker.getCommand(commandAndArg[0]);
                            if (commandWithObject != null) {
                                ArrayList<String> params = new ArrayList<>();
                                try {
                                    for (int j = 0; j < 11; j++) {
                                        i++;
                                        params.add(commands[i]);
                                    }
                                    Dragonborn.isFromScript = true;
                                    Dragonborn creater = new Dragonborn();
                                    creater.createFromFile(params);
                                    System.out.println("\nКоманда \"" + commands[i - 11] + "\":");
                                    command.executeCommand(commands[i - 11]);
                                    Dragonborn.isFromScript = false;
                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Команда \"" + commandAndArg + "\":");
                                    System.out.println("Недостаточно параметров");
                                }
                            }
                        } catch (Exception e) {
                            if (isValidScript) {
                                System.out.println("Команда \"" + commands[i] + "\":");
                                command.executeCommand(commands[i]);
                                System.out.println();
                            } else {
                                System.out.println("Команда \"" + commands[i] + "\": невыполнима.\n");
                            }
                        }
                    }
                }
            } else System.out.println("Указанный файл не найден.");
        } catch (NullPointerException | FileNotFoundException e) {

        } finally {
            scripts.clear();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
