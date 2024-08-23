package architecture.furniture;

import enums.FurnitureType;
import exceptions.FurnitureAlreadyInUseException;

public class Chair extends Furniture {

    public Chair() {
        super(FurnitureType.CHAIR);
    }

    public void sitOn() {
        if (isInUse()) {
            throw new FurnitureAlreadyInUseException("cтул уже используется");
        } else {
            System.out.println("вы садитесь на стул");
            setInUse(true);
        }
    }

    public void standUp() {
        if (isInUse()) {
            System.out.println("вы встаете со стула");
            setInUse(false);
        } else {
            System.out.println("стул уже свободен");
        }
    }
}