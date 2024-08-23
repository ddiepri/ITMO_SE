package architecture.furniture;

import enums.FurnitureType;

public class Table extends Furniture {

    public Table() {
        super(FurnitureType.TABLE);
    }

    public void clearTable() {
        System.out.println("стол очищен от предметов");
    }

    public void setTable() {
        System.out.println("стол накрыт");
    }
}
