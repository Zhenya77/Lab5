package Commands;

import Controller.CommandWithObject;
import Controller.DragonCollection;
import Dragon.Dragon;
import Dragon.Dragonborn;

import java.util.InputMismatchException;

public class Update implements CommandWithObject {
    String name = "update";
    Dragonborn creater = new Dragonborn();
    DragonCollection collection = new DragonCollection();

    @Override
    public void execute(Object arg) {
        try {
            int id = Integer.parseInt((String) arg);
            if (this.check(id)) {
                Dragon dragon = this.getNewDragon(null);
                if (dragon != null) {
                    dragon.setId(id);
                    collection.update((Integer) id, dragon);
                    System.out.println("Дракон с id[" + arg + "] успешно обновлен.");
                }
            } else System.out.println("Дракон с указанным id не найден.");
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

