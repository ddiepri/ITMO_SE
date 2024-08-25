package command;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Команда "filter_less_than_number_of_rooms numberOfRooms".
 * Описание команды: вывести элементы, значение поля numberOfRooms которых меньше заданного.
 */
public class FilterLessThanNumberOfRoomsCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CollectionManager manager;

    public FilterLessThanNumberOfRoomsCommand(ConsoleManager console, CollectionManager manager) {
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
            console.printError("команда требует один аргумент — число для фильтрации по количеству комнат");
            return 1;
        }

        try {
            Long numberOfRooms = Long.parseLong(args[0]);

            manager.getCollection().values().stream()
                    .filter(flat -> flat.getNumberOfRooms() < numberOfRooms)
                    .forEach(flat -> console.println(flat.toString()));

            return 0;
        } catch (NumberFormatException e) {
            console.printError("аргумент должен быть числом");
            return 2;
        }
    }

    @Override
    public String toString() {
        return " <numberOfRooms> : вывести элементы, значение поля numberOfRooms которых меньше заданного";
    }
}
