package Commands;

import Controller.CommandWithoutArg;
import Controller.DragonCollection;
import Dragon.Dragon;
import Utilites.WriterToFile;

import java.io.FileNotFoundException;
import java.util.Map;

public class Save implements CommandWithoutArg {
    String name = "save";
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object o) throws FileNotFoundException {
            WriterToFile.writeDragonToFile(collection.getCollection());

        System.out.println("Коллекция успешно сохранена.");
    }


    @Override
    public String getName() {
        return name;
    }
}

