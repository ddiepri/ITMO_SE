package enums;

public enum FurnitureType {
    TABLE("стол"),
    CHAIR("стул"),
    WARDROBE("шкаф"),
    SOFA("диван"),
    BED("кровать"),
    DESK("письменный стол"),
    SHELF("полка");

    private final String description;

    FurnitureType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}