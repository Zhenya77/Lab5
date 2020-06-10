package Commands;

import Controller.Commandable;
import Controller.DragonCollection;
import Dragon.Dragon;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;

public class Remove_lower_key implements Commandable {
    DragonCollection collection = new DragonCollection();
    String name = "remove_lower_key";

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
                    if (v.getId() < Integer.parseInt((String) arg)) {
                        tumb = true;
                        collection.remove(k);
                        System.out.println("Дракон с id:[" + k + "] успешно удален.");
                    }
                }
                if (!tumb) System.out.println("Драконов с меньшим id не найдено.");
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