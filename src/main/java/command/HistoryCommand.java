package command;

import manager.CommandManager;
import manager.ConsoleManager;

/**
 * Команда "history".
 * Описание команды: вывести последние 9 команд (без их аргументов).
 */
public class HistoryCommand implements CommandInterface {
    private final ConsoleManager console;
    private final CommandManager manager;

    public HistoryCommand(ConsoleManager console, CommandManager manager) {
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

        console.println("последние 9 команд:");
        manager.getHistory().forEach(console::println);

        return 0;
    }

    @Override
    public String toString() {
        return ": вывести последние 9 команд (без их аргументов)";
    }
}
