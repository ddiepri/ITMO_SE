package manager;

import models.Coordinates;
import models.Flat;
import models.House;

/**
 * Класс для валидации объектов.
 */
public class ValidationManager {

    private ValidationManager() {
    }

    /**
     * Проверяет валидность объекта Flat.
     *
     * @param flat объект Flat
     * @return true, если объект валиден, иначе false
     */
    public static boolean isValidFlat(Flat flat) {
        return flat.getId() != null && 
                flat.getId() > 0 &&

                flat.getName() != null &&
                !flat.getName().isEmpty() &&

                flat.getCoordinates() != null &&
                isValidCoordinates(flat.getCoordinates()) &&

                flat.getCreationDate() != null &&

                flat.getArea() != null &&
                flat.getArea() > 0 &&

                flat.getNumberOfRooms() != null &&
                flat.getNumberOfRooms() > 0 &&

                flat.getTimeToMetroByTransport() != null &&
                flat.getTimeToMetroByTransport() > 0 &&

                flat.getView() != null &&

                flat.getHouse() != null &&
                isValidHouse(flat.getHouse());
    }

    /**
     * Проверяет валидность объекта House.
     *
     * @param house объект House
     * @return true, если объект валиден, иначе false
     */
    public static boolean isValidHouse(House house) {
        return house.getYear() > 0 &&

                house.getNumberOfFlatsOnFloor() > 0;
    }

    /**
     * Проверяет валидность координат.
     *
     * @param coordinates объект координат
     * @return true, если объект валиден, иначе false
     */
    public static boolean isValidCoordinates(Coordinates coordinates) {
        return coordinates.getY() != null;
    }
}
