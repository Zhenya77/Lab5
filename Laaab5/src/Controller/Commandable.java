package Controller;

import java.io.FileNotFoundException;

public interface Commandable {
    public void execute(Object o) throws FileNotFoundException;
    public String getName();
}
