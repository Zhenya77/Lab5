package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Controller.DragonCollection;

public class Clear implements CommandWithoutArg {
    String name = "clear";
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
        else {
            collection.clear();
            System.out.println("Коллекция очищена");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}