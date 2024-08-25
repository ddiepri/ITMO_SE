package manager;

import command.CommandInterface;
import java.util.HashMap;
import java.util.LinkedList;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс для управления командами.
 */
@Getter
@Setter
public class CommandManager {
    private final HashMap<String, CommandInterface> commands = new HashMap<>();
    private final ConsoleManager console;
    private final LinkedList<String> history = new LinkedList<>();
    private final int historySize = 9;

    public CommandManager(ConsoleManager console) {
        this.console = console;
    }

    /**
     * Добавить команду.
     *
     * @param name    имя команды
     * @param command команда
     */
    public void addCommand(String name, CommandInterface command) {
        commands.put(name, command);
    }

    /**
     * Выполнить команду.
     *
     * @param name имя команды
     * @param args аргументы
     * @return код завершения
     */
    public int executeCommand(String name, String[] args) {
        CommandInterface command = commands.get(name);
        if (command != null) {
            try {
                addCommandToHistory(name);
                return command.execute(args);
            } catch (Exception e) {
                console.printError(e.getClass().getName());
                return -1;
            }
        }
        console.println("Команда не найдена! Попробуйте ввести 'help' для получения списка команд.");
        return -1;
    }

    /**
     * Добавить команду в историю.
     *
     * @param commandName имя команды
     */
    private void addCommandToHistory(String commandName) {
        if (history.size() == historySize) {
            history.removeFirst();
        }
        history.add(commandName);
    }

    /**
     * Получить историю команд.
     *
     * @return список последних 9 команд
     */
    public LinkedList<String> getHistory() {
        return history;
    }
}
