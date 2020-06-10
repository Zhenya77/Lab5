package Commands;

import Controller.CommandWithObject;
import Controller.DragonCollection;
import Dragon.Dragon;
import Dragon.Dragonborn;

import java.util.InputMismatchException;

public class Insert implements CommandWithObject {
    String name = "insert";
    DragonCollection collection = new DragonCollection();
    Dragonborn creater = new Dragonborn();

    @Override
    public void execute(Object arg) {
        try {
            int id = Integer.parseInt((String) arg);
            if (this.check(id)) {
                Dragon dragon = this.getNewDragon(null);
                dragon.setId(id);
                collection.insert((Integer) id, dragon);
                System.out.println("Дракон залетел в коллекцию.");
            } else System.out.println("Указанный ключ занят");
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
        return collection.isKeyFree((Integer) arg);
    }

    @Override
    public Dragon getNewDragon(Object params) {
        if (Dragonborn.isFromScript == false) return creater.create();
        else return Dragonborn.dragonFromScript;
    }
}

