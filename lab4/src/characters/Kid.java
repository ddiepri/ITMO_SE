package characters;

import interfaces.Lockable;
import architecture.furniture.Furniture;

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

    public void promiseToHelp() {
        System.out.println(this + " обещал помогать Карлсону чем сможет");
    }

    public void considerBadIdea() {
        System.out.println(this + " не считал, что это лучший способ позабавиться");
    }

    public void sneakToFurniture(Furniture furniture) {
        System.out.print(this + " подкрался к " + furniture.getType());
    }

    public void sitOnFurniture(Furniture furniture) {
        System.out.println(this + " сел на " + furniture.getType());
    }

    public void listen() {
        System.out.println(this + " слышит");
    }

    public void waitMoment() {
        System.out.print(this + " ждал этого момента");
    }
}