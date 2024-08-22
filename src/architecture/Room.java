package architecture;

import enums.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room extends Structure {
    private RoomType roomType;
    private List<Structure> components;

    public Room(RoomType roomType) {
        this.roomType = roomType;
        this.components = new ArrayList<>();
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void addComponent(Structure component) {
        components.add(component);
    }

    public List<Structure> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return super.toString() + " (тип: " + roomType + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return roomType == room.roomType && Objects.equals(components, room.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomType, components);
    }
}
