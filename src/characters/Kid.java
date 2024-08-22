package characters;

import interfaces.Lockable;

public class Kid extends Character {

    public Kid() {
        super("Малыш");
    }

    public void giggle() {
        System.out.println(this + " расхохотался");
    }

    public void checkDoorStatus(Lockable door) {
        if (door.isLocked()) {
            System.out.println(this + " услышал, что дверь заперта");
        } else {
            System.out.println(this + " обнаружил, что дверь не заперта");
        }
    }
}
