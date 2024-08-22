package architecture;

public abstract class RoomItem {
    @Override
    public String toString() {
        return "предмет комнаты ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomItem roomItem = (RoomItem) o;
        return this.hashCode() == roomItem.hashCode();
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode();
    }
}
