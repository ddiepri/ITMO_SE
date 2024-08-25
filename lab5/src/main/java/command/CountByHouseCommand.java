package command;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.House;
import models.forms.HouseForm;

/**
 * Команда "count_by_house house".
 * Описание команды: вывести количество элементов, значение поля house которых равно заданному.
 */
public class CountByHouseCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CollectionManager manager;

    public CountByHouseCommand(ConsoleManager console, CollectionManager manager) {
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
            console.printError("команда не принимает аргументы. Поле house вводится интерактивно.");
            return 1;
        }

        // Получение объекта House от пользователя
        House house = new HouseForm(console).build();

        // Подсчет элементов, соответствующих заданному объекту House
        long count = manager.getCollection().values().stream()
                .filter(flat -> house.equals(flat.getHouse()))
                .count();

        console.println("количество элементов, значение поля house которых равно заданному: " + count);
        return 0;
    }

    @Override
    public String toString() {
        return ": вывести количество элементов, значение поля house которых равно заданному";
    }
}
