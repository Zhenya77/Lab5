package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Controller.DragonCollection;

public class Exit implements CommandWithoutArg {
    String name = "exit";
    DragonCollection collection = new DragonCollection();

    /**
     * exit your program
     *
     * @param o
     */
    @Override
    public void execute(Object o) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return name;
    }
}