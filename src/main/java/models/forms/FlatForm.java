package models.forms;

import java.time.LocalDate;

import manager.ConsoleManager;
import manager.IdManager;
import models.Coordinates;
import models.Flat;
import models.House;
import models.View;

/**
 * Форма для создания объекта класса {@link Flat}.
 */
public class FlatForm extends Form<Flat> {
    private final ConsoleManager console;

    public FlatForm(ConsoleManager console) {
        super(console);
        this.console = console;
    }

    /**
     * Формирует объект класса {@link Flat}.
     *
     * @return Объект класса {@link Flat}
     */
    @Override
    public Flat build() {
        return new Flat(
                IdManager.generateId(), // Генерация уникального идентификатора
                askString("название квартиры", " (строка, поле не может быть пустым)", s -> !s.isEmpty()),
                askCoordinates(), // Ввод координат через форму CoordinatesForm
                LocalDate.now(), // Дата создания генерируется автоматически
                askLong("площадь квартиры", " (целое число, значение должно быть больше нуля)", x -> (x != null && x > 0)),
                askLong("количество комнат", " (целое число, значение должно быть больше нуля)", x -> (x != null && x > 0)),
                askBoolean("новая квартира?", " (введите true или false)", s -> s != null), // Ввод значения isNew
                askFloat("время до метро на транспорте", " (дробное число, значение должно быть больше нуля)", x -> (x != null && x > 0)),
                askView(), // Ввод значения View через перечисление
                askHouse() // Ввод объекта House через форму HouseForm
        );
    }

    private Coordinates askCoordinates() {
        return new CoordinatesForm(console).build();
    }

    private House askHouse() {
        return new HouseForm(console).build();
    }

    private View askView() {
        return (View) askEnum("вид из окна", View.values(), s -> true);
    }
}
