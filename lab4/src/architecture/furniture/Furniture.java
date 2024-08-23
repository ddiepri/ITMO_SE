package architecture.furniture;

import enums.FurnitureType;

public class Furniture {
    private FurnitureType type;
    private boolean inUse;  

    public Furniture(FurnitureType type) {
        this.type = type;
        this.inUse = false;  
    }

    public FurnitureType getType() {
        return type;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}