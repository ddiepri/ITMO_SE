package manager;

import lombok.Getter;
import lombok.Setter;
import models.Flat;
import models.House;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Класс для управления коллекцией.
 */
@Getter
@Setter
public class CollectionManager {
    /**
     * Время инициализации коллекции.
     */
    private static Date initializationTime = new Date();

    /**
     * Коллекция.
     */
    private LinkedHashMap<Long, Flat> collection = new LinkedHashMap<>();

    /**
     * Добавить элемент в коллекцию.
     *
     * @param id идентификатор элемента
     * @param o  элемент
     */
    public void add(Long id, Flat o) {
        collection.put(id, o);
    }

    /**
     * Возвращает время инициализации коллекции.
     *
     * @return дата инициализации коллекции.
     */
    public Date getInitializationTime() {
        return initializationTime;
    }
    
    public LinkedHashMap<Long, Flat> getCollection() {
        return collection;
    }

    /**
     * Обновить элемент коллекции по id.
     *
     * @param id id элемента
     * @param o  новый элемент
     */
    public void update(long id, Flat o) {
        if (collection.containsKey(id)) {
            collection.put(id, o);
        } else {
            throw new IllegalArgumentException("Элемент с указанным id не найден.");
        }
    }

    /**
     * Удалить элемент по id.
     *
     * @param id id элемента
     */
    public void removeById(long id) {
        collection.remove(id);
    }

    /**
     * Очистить коллекцию.
     */
    public void clear() {
        initializationTime = new Date();
        collection.clear();
    }

    /**
     * Показать информацию о коллекции.
     *
     * @return информация о коллекции
     */
    public String info() {
        return "Тип коллекции: " + collection.getClass().getName() +
                "\nДата инициализации: " + initializationTime +
                "\nКоличество элементов: " + collection.size();
    }

    /**
     * Вернуть все элементы коллекции в строковом представлении.
     *
     * @return элементы коллекции
     */
    public String show() {
        StringBuilder sb = new StringBuilder();
        collection.forEach((id, flat) -> sb.append(id).append(": ").append(flat).append("\n"));
        return sb.toString();
    }

    /**
     * Удалить элементы, которые больше заданного.
     *
     * @param o объект для сравнения
     */
    public void removeGreater(Flat o) {
        collection.entrySet().removeIf(entry -> entry.getValue().compareTo(o) > 0);
    }

    /**
     * Удалить элементы, ключ которых меньше заданного.
     *
     * @param key ключ для сравнения
     */
    public void removeLowerKey(Long key) {
        collection.entrySet().removeIf(entry -> entry.getKey() < key);
    }

    /**
     * Вернуть элемент по id.
     *
     * @param id id элемента
     * @return элемент или null, если элемент не найден
     */
    public Flat getById(long id) {
        return collection.get(id);
    }

    /**
     * Подсчитать количество элементов с заданным значением поля house.
     *
     * @param house объект House
     * @return количество элементов
     */
    public long countByHouse(House house) {
        return collection.values().stream().filter(flat -> flat.getHouse().equals(house)).count();
    }

    /**
     * Фильтровать элементы, значение поля numberOfRooms которых меньше заданного.
     *
     * @param numberOfRooms количество комнат
     * @return список элементов, удовлетворяющих условию
     */
    public List<Flat> filterLessThanNumberOfRooms(Long numberOfRooms) {
        return collection.values().stream().filter(flat -> flat.getNumberOfRooms() < numberOfRooms).toList();
    }

    /**
     * Вывести элементы коллекции в порядке убывания.
     *
     * @return элементы коллекции в порядке убывания
     */
    public String printDescending() {
        StringBuilder sb = new StringBuilder();
        collection.values().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(flat -> sb.append(flat).append("\n"));
        return sb.toString();
    }

    /**
     * Сохранить коллекцию в файл.
     *
     * @param filename имя файла
     */
    public void save(String filename) {
        // Реализация сохранения коллекции в XML-файл с использованием FileOutputStream
    }

    /**
     * Загрузить коллекцию из файла.
     *
     * @param filename имя файла
     */
    public void load(String filename) {
        // Реализация загрузки коллекции из XML-файла с использованием BufferedReader
    }
}
