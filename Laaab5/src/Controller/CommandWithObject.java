package Controller;

import Dragon.Dragon;

public interface CommandWithObject extends Commandable{
    public boolean check(Object arg);
    public Dragon getNewDragon(Object params);
}
