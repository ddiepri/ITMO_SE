package enums;

public enum RoomType {
    KITCHEN("кухня"),
    LIVING_ROOM("гостиная"),
    BEDROOM("спальня"),
    ROOMKID("комната Малыша"),
    BATHROOM("ванная");

    private final String description;

    RoomType(String description) {
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