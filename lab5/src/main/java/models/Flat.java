package models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Comparator;

/**
 * 
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Flat implements Comparable<Flat> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long area; //Значение поля должно быть больше 0
    private Long numberOfRooms; //Поле не может быть null, Значение поля должно быть больше 0
    private Boolean isNew; //Поле может быть null
    private Float timeToMetroByTransport; //Значение поля должно быть больше 0
    private View view; //Поле не может быть null
    private House house; //Поле не может быть null

    @Override
    public int compareTo(Flat other) {
        return Comparator.comparingLong(Flat::getArea)
                .thenComparingLong(Flat::getId)
                .compare(this, other);
    }
}