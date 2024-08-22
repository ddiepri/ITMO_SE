package architecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Apartment extends Structure {
    private List<Room> rooms;

    public Apartment() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return super.toString() + " с " + rooms.size() + " комнатами";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Apartment apartment = (Apartment) obj;
        return Objects.equals(rooms, apartment.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rooms);
    }
}