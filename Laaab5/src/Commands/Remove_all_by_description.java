package Commands;

import Controller.Commandable;
import Controller.DragonCollection;
import Dragon.Dragon;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;

public class Remove_all_by_description implements Commandable {
    DragonCollection collection = new DragonCollection();
    String name = "remove_all_by_description";

    @Override
    public void execute(Object arg) {
        try {
            boolean tumb = false;
            if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
            else {
                Hashtable<Integer, Dragon> dragons = collection.getCollection();
                Enumeration keys = dragons.keys();
                while (keys.hasMoreElements()) {
                    Integer k = (Integer) keys.nextElement();
                    Dragon v = dragons.get(k);
                    if (v.getDescription() == arg) {
                        tumb = true;
                        collection.remove(k);
                        System.out.println("Дракон с id:[" + k + "] успешно удален.");
                    }
                }
                if (!tumb) System.out.println("Драконов с таким описанием не найдено.");
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}