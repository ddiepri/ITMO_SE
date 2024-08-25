package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "remove_key null".
 * Описание команды: удалить элемент из коллекции по его ключу.
 */
public class RemoveKeyCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CollectionManager manager;

    public RemoveKeyCommand(ConsoleManager console, CollectionManager manager) {
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
        if (args.length != 1) {
            console.printError("команда требует один аргумент — ключ элемента, который нужно удалить");
            return 1;
        }

        try {
            Long key = Long.parseLong(args[0]);
            if (manager.getCollection().containsKey(key)) {
                manager.getCollection().remove(key);
                console.println("элемент с ключом " + key + " успешно удален");
                return 0;
            } else {
                console.printError("элемент с ключом " + key + " не найден в коллекции");
                return 2;
            }
        } catch (NumberFormatException e) {
            console.printError("ключ должен быть числом");
            return 3;
        }
    }

    @Override
    public String toString() {
        return ": удалить элемент из коллекции по его ключу";
    }
}