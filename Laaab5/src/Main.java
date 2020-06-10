import Commands.*;
import Controller.Commands;
import Utilites.*;
import Utilites.ReaderFromFile;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = System.getenv("file");
        Collection collection = new Collection();
        ReaderFromFile reader = new ReaderFromFile();
        collection.toFill(reader.readFromFile(filename));
        Show show = new Show();
        Info info = new Info();
        Help help = new Help();
        Clear clear = new Clear();
        Exit exit = new Exit();
        Insert insert = new Insert();
        Save save = new Save();
        Update update = new Update();
        Commands commands = new Commands();
        Average_of_age average_of_age = new Average_of_age();
        Remove_key remove_key = new Remove_key();
        Replace_if_greater replace_if_greater = new Replace_if_greater();
        History history = new History();
        Execute_script execute_script = new Execute_script();
        Min_by_description min_by_description = new Min_by_description();
        Remove_lower_key remove_lower_key = new Remove_lower_key();
        Remove_all_by_description remove_all_by_description = new Remove_all_by_description();
        commands.regist(show, remove_lower_key, min_by_description, execute_script, history, remove_all_by_description, info, help, clear, exit, remove_key, insert, replace_if_greater, save, average_of_age, update);
        while (true) {
            String commandName = Console.read();
            if (!commandName.equals(""))
                commands.executeCommand(commandName);

        }
    }
}
