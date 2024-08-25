package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Coordinates {
    private double x;
    private Float y; //Поле не может быть null
}