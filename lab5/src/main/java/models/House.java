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
public class House implements Comparable<House> {
    private String name; //Поле может быть null
    private int year; //Значение поля должно быть больше 0
    private long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    @Override
    public int compareTo(House other) {
        return Comparator.comparingInt(House::getYear)
                .thenComparingLong(House::getNumberOfFlatsOnFloor)
                .compare(this, other);
    }
}