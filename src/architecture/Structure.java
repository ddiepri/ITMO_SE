package architecture;

import java.util.Objects;

public abstract class Structure {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public String toString() {
        return "структура " + this.getClass().getSimpleName();
    }
}
