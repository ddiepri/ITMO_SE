package architecture.items;

import interfaces.Lockable;
import java.util.Objects;
import architecture.sctructures.Room;

public class Window extends RoomItem implements Lockable {
    private boolean locked;
    private Room room;

    public Window() {
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
            return "окно в " + room.getRoomType().getDescription();
        } else {
            return "окно без привязки к комнате";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Window window = (Window) obj;
        return locked == window.locked && Objects.equals(room, window.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locked, room);
    }
}