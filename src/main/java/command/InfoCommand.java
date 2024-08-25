package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "info".
 * Описание команды: вывести в стандартный поток вывода информацию о коллекции.
 */
public class InfoCommand implements CommandInterface {
    ConsoleManager console;
    CollectionManager manager;

    public InfoCommand(ConsoleManager console, CollectionManager manager) {
        this.console = console;
        this.manager = manager;
    }

    /**
     * Выполнение команды.
     *
     * @param args аргументы
     */
    @Override
    public int execute(String[] args) {
        if (args.length != 0) {
            console.printError("команда не принимает аргументы");
            return 1;
        }

        console.println("дата инициализации коллекции: " + manager.getInitializationTime());
        var collection = manager.getCollection();
        console.println("тип коллекции: " + collection.getClass().getName());
        console.println("размер коллекции: " + collection.size());

        return 0;
    }

    @Override
    public String toString() {
        return ": вывести в стандартный поток вывода информацию о коллекции";
    }
}