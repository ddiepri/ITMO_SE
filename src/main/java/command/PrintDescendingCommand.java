package command;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import manager.CollectionManager;
import manager.ConsoleManager;
import models.Flat;

/**
 * Команда "print_descending".
 * Описание команды: вывести элементы коллекции в порядке убывания.
 */
public class PrintDescendingCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CollectionManager manager;

    public PrintDescendingCommand(ConsoleManager console, CollectionManager manager) {
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

        List<Map.Entry<Long, Flat>> sortedList = new ArrayList<>(manager.getCollection().entrySet());
        sortedList.sort(Map.Entry.<Long, Flat>comparingByValue(Comparator.reverseOrder()));


        if (sortedList.isEmpty()) {
            console.println("коллекция пуста");
        } else {
            console.println("элементы коллекции в порядке убывания:");
            sortedList.forEach(entry -> console.println(entry.getValue().toString()));
        }

        return 0;
    }

    @Override
    public String toString() {
        return ": вывести элементы коллекции в порядке убывания";
    }
}
