package command;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.Flat;
import models.forms.FlatForm;

/**
 * Команда "insert null {element}".
 * Описание команды: добавить новый элемент с заданным ключом.
 */
public class InsertCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CollectionManager manager;

    public InsertCommand(ConsoleManager console, CollectionManager manager) {
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
            console.printError("Команда требует один аргумент — ключ (null).");
            return 1;
        }

        try {
            Long key = Long.parseLong(args[0]);

            if (manager.getCollection().containsKey(key)) {
                console.printError("Элемент с ключом " + key + " уже существует в коллекции.");
                return 2;
            }

            // Создание нового объекта Flat с использованием формы
            Flat flat = new FlatForm(console).build();

            // Добавление элемента в коллекцию
            manager.getCollection().put(key, flat);
            console.println("Элемент с ключом " + key + " успешно добавлен в коллекцию.");

            return 0;
        } catch (NumberFormatException e) {
            console.printError("Ключ должен быть числом.");
            return 3;
        }
    }

    @Override
    public String toString() {
        return " <null> {element} : добавить новый элемент с заданным ключом";
    }
}
