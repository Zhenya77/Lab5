package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Controller.Commands;
import Controller.DragonCollection;

import java.util.ArrayList;

public class History implements CommandWithoutArg {
    String name = "history";

    @Override
    public void execute(Object o) {
        ArrayList<String> history = Commands.getHistory();
        if (history.size() == 0) System.out.println("История пустая.");
        else {
            int numOfCommands = history.size();
            System.out.println("Последние выполненные команды:");
            try{
                for(int i=numOfCommands;i > numOfCommands-6;i--)
                    System.out.println(history.get(i));
            }
            catch(IndexOutOfBoundsException e) {
                for(int i=0;i < numOfCommands;i++)
                    System.out.println(history.get(i));

            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

