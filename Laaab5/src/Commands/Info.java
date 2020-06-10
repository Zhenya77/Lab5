package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Controller.DragonCollection;


public class Info implements CommandWithoutArg {
    String name = "info";
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object o) {
        System.out.println(collection.getInfo());
    }

    @Override
    public String getName() {
        return name;
    }
}
