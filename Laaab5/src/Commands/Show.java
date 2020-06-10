package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Controller.DragonCollection;
import Dragon.Dragon;

import java.util.Map;

public class Show implements CommandWithoutArg {
    String name = "show";
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
        else for (Map.Entry<Integer, Dragon> entry : collection.getCollection().entrySet())
            System.out.println(entry.getValue().getInfo());
    }

    @Override
    public String getName() {
        return name;
    }
}
