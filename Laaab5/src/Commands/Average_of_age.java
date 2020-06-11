package Commands;

import Controller.CommandWithoutArg;
import Controller.DragonCollection;
import Dragon.Dragon;

import java.util.Map;

public class Average_of_age implements CommandWithoutArg {
    String name = "average_of_age";
    DragonCollection collection = new DragonCollection();

    /**
     * if collection is nor empty than show average age of all dragons
     *
     * @param o
     */
    @Override
    public void execute(Object o) {
        if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
        else {
            long middleAge = 0;
            for (Map.Entry<Integer, Dragon> entry : collection.getCollection().entrySet())
                middleAge += entry.getValue().getAge();

                System.out.println("Средний возраст дракона: " + middleAge/collection.getSize() );
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

