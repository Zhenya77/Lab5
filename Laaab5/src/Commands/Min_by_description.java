package Commands;

import Controller.CommandWithoutArg;
import Controller.DragonCollection;
import Dragon.Dragon;

import java.util.Enumeration;
import java.util.Hashtable;

public class Min_by_description implements CommandWithoutArg {
    String name = "min_by_description";
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object arg) {
        if (collection.getSize() == 0) System.out.println("Коллекция пустая.");
        else {
            String minDescription = "";
            Integer key = -152;
            int tumb = 0;
            Hashtable<Integer, Dragon> dragons = collection.getCollection();
            Enumeration keys = dragons.keys();
            while (keys.hasMoreElements()) {
                Integer k = (Integer) keys.nextElement();
                Dragon v = dragons.get(k);
                if (tumb == 0) {
                    minDescription = v.getDescription();
                    key = k;
                    tumb++;
                }
                if (v.getDescription().length() < minDescription.length()) {
                    minDescription = v.getDescription();
                    key = k;
                }
            }
            System.out.println(collection.getCollection().get(key).getInfo());
        }
    }

    @Override
    public String getName() {
        return name;
    }
}

