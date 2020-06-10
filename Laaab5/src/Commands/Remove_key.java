package Commands;

import Controller.Commandable;
import Controller.DragonCollection;
import Dragon.Dragon;

import java.util.Map;

public class Remove_key implements Commandable {
    String name = "remove_key";
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object arg) {
        try {
            boolean tumb = false;
            if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
            else {
                for (Map.Entry<Integer, Dragon> entry : collection.getCollection().entrySet())
                    if (entry.getKey() == Integer.parseInt((String) arg)) {
                        tumb = true;
                        collection.remove(entry.getKey());
                        System.out.println("Элемент с id[" + arg + "] успешно удален.");
                    }
                if (!tumb) System.out.println("Дракон с указанным id не найден.");
            }
        } catch (Exception e) {
            System.out.println("Аргумент команды должен быть типа \"int\"");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

