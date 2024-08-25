package command;

import java.util.Iterator;
import java.util.Map;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.Flat;

/**
 * Команда "remove_lower_key null".
 * Описание команды: удалить из коллекции все элементы, ключ которых меньше, чем заданный.
 */
public class RemoveLowerKeyCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CollectionManager manager;

    public RemoveLowerKeyCommand(ConsoleManager console, CollectionManager manager) {
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
            console.printError("команда требует один аргумент — ключ, с которым будут сравниваться ключи элементов коллекции");
            return 1;
        }

        try {
            Long thresholdKey = Long.parseLong(args[0]);
            Iterator<Map.Entry<Long, Flat>> iterator = manager.getCollection().entrySet().iterator();

            int removedCount = 0;

            while (iterator.hasNext()) {
                Map.Entry<Long, Flat> entry = iterator.next();
                if (entry.getKey() < thresholdKey) {
                    iterator.remove();
                    removedCount++;
                }
            }

            console.println("удалено " + removedCount + " элементов с ключами, меньшими чем " + thresholdKey + ".");
            return 0;
        } catch (NumberFormatException e) {
            console.printError("Ключ должен быть числом.");
            return 2;
        }
    }

    @Override
    public String toString() {
        return ": удалить из коллекции все элементы, ключ которых меньше, чем заданный";
    }
}