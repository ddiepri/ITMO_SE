import command.*;
import manager.*;

public class Main {
    public static void main(String[] args) {
        ConsoleManager console = new ConsoleManager();
        CommandManager commandManager = new CommandManager(console);
        CollectionManager collectionManager = new CollectionManager();

        String filename = System.getenv("FILE_NAME");
        if (filename == null || filename.isEmpty()) {
            console.printError("Переменная окружения FILE_NAME не установлена, использую файл по умолчанию: data.xml");
            filename = "data.xml";
        }

        FileManager fileManager = new FileManager(filename, console, collectionManager);
        IdManager.setCollectionManager(collectionManager);

        commandManager.addCommand("help", new HelpCommand(console, commandManager));
        commandManager.addCommand("info", new InfoCommand(console, collectionManager));
        commandManager.addCommand("show", new ShowCommand(console, collectionManager));
        commandManager.addCommand("insert null", new InsertCommand(console, collectionManager));
        commandManager.addCommand("update", new UpdateCommand(console, collectionManager));
        commandManager.addCommand("remove_key null", new RemoveKeyCommand(console, collectionManager));
        commandManager.addCommand("clear", new ClearCommand(console, collectionManager));
        commandManager.addCommand("save", new SaveCommand(console, fileManager));
        commandManager.addCommand("execute_script", new ExecuteScriptCommand(console, commandManager));
        commandManager.addCommand("exit", new ExitCommand(console));
        commandManager.addCommand("remove_greater", new RemoveGreaterCommand(console, collectionManager));
        commandManager.addCommand("history", new HistoryCommand(console, commandManager));
        commandManager.addCommand("remove_lower_key null", new  RemoveKeyCommand(console, collectionManager));
        commandManager.addCommand("count_by_house house", new CountByHouseCommand(console, collectionManager));
        commandManager.addCommand("filter_less_than_number_of_rooms", new FilterLessThanNumberOfRoomsCommand(console, collectionManager));
        commandManager.addCommand("print_descending", new PrintDescendingCommand(console, collectionManager));

        new RuntimeManager(commandManager, fileManager, console).interactiveMode();
    }
}