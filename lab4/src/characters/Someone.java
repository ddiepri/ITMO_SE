package characters;

import interfaces.Lockable;

public class Someone extends Character {

    public Someone() {
        super();
    }

    public void lock(Lockable door) {
        System.out.print(this + " запирает снаружи " + door.toString());
        door.lock();
    }
}