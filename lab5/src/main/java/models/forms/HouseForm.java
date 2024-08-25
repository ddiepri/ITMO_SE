package models.forms;

import manager.ConsoleManager;
import models.House;

/**
 * Форма для создания объекта класса {@link House}.
 */
public class HouseForm extends Form<House> {
    private final ConsoleManager console;

    public HouseForm(ConsoleManager console) {
        super(console);
        this.console = console;
    }

    /**
     * Формирует объект класса {@link House}.
     *
     * @return Объект класса {@link House}
     */
    @Override
    public House build() {
        return new House(
                askString("название дома", " (строка, поле может быть пустым)", s -> true),
                askInteger("год постройки дома", " (целое число, значение должно быть больше нуля)", x -> x != null && x > 0),
                askLong("количество квартир на этаже", " (целое число, значение должно быть больше нуля)", x -> x != null && x > 0)
        );
    }
}
