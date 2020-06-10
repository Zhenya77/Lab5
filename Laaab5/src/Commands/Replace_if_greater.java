package Commands;

import Controller.CommandWithObject;
import Controller.DragonCollection;
import Dragon.Dragon;
import Dragon.Dragonborn;

import java.util.InputMismatchException;

public class Replace_if_greater implements CommandWithObject {
    String name = "replace_if_greater";
    DragonCollection collection = new DragonCollection();
    Dragonborn creater = new Dragonborn();

    @Override
    public void execute(Object args) {
        try {
            if (collection.getSize() == 0) System.out.println("Коллекция итак пустая.");
            else {
                int arg = Integer.parseInt((String) args);
                if (this.check(arg)) {
                    Dragon newDragon = this.getNewDragon(null);
                    if (newDragon != null) {
                        if (collection.getCollection().get(arg).compareTo(newDragon) < 0) {
                            newDragon.setId(arg);
                            collection.update(arg, newDragon);
                            System.out.println("Дракон с id[" + arg + "] успешно заменен.");
                        } else System.out.println("Дракон с id[" + arg + "] не заменен.");
                    }
                } else System.out.println("Драконов с указанным id не найдено.");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Аргумент команды должен быть типа \"int\"");
        }
        catch (NullPointerException e){
            System.out.println("Неверно указаны данные.");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean check(Object arg) {
        return !collection.isKeyFree((Integer) arg);
    }

    @Override
    public Dragon getNewDragon(Object params) {
        if (Dragonborn.isFromScript == false) return creater.create();
        else return Dragonborn.dragonFromScript;
    }
}


