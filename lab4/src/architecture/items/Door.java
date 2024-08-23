package architecture.items;

import interfaces.Lockable;
import java.util.Objects;

import architecture.sctructures.Room;

public class Door extends RoomItem implements Lockable {
    private boolean locked;
    private Room room; 

    public Door() {
        this.locked = false;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void lock() {
        this.locked = true;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void unlock() {
        this.locked = false;
    }

    @Override
    public String toString() {
        if (room != null) {
            return "дверь в " + room.getRoomType().getDescription();
        } else {
            return "дверь без привязки к комнате";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Door door = (Door) obj;
        return locked == door.locked && Objects.equals(room, door.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locked, room);
    }
}