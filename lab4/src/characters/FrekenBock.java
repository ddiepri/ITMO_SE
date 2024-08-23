package characters;

import architecture.furniture.Furniture;
import architecture.furniture.Wardrobe.WardrobeDoor;
import architecture.items.Door;
import exceptions.DoorLockedException;
import interfaces.Thinkable;

public class FrekenBock extends Character implements Thinkable {

    public FrekenBock() {
        super("Фрекен Бок");
    }

    public void noticeNothing() {
        System.out.println(this + " ничего не заметила");
    }

    @Override
    public void think() {
        System.out.println(this + " о чем-то думает");
    }

    public void stand() {
        System.out.print(this + " стоит");
    }

    // анонимный класс
    public void tryToOpenDoor(Door door) {
        Character self = this;
    
        Runnable doorOpeningAttempt = new Runnable() {
            @Override
            public void run() {
                System.out.println(self + " взялась за ручку и попыталась открыть дверь");
                try {
                    if (door.isLocked()) {
                        throw new DoorLockedException("дверь не открылась");
                    }
                    System.out.println("дверь открылась");
                } catch (DoorLockedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        doorOpeningAttempt.run();
    }

    public void roar() {
        System.out.println(this + " взревела");
    }

    public void pushWithBody(Door door) {
        System.out.println(this + " навалилась на " + door + " всем телом, но это не помогло");
    }

    public void search(Furniture furniture) {
        System.out.println(this + " обшаривает " + furniture.getType());
    }

    public void turnAround() {
        System.out.println(this + " сейчас обернется");
    }

    public void emergeFrom(Furniture furniture) {
        System.out.println(this + " вынырнула из " + furniture.getType());
    }

    public void see(Object obj) {
        System.out.println(this + " увидела " + obj);
    }

    public void stepBack() {
        System.out.println(this + " попятилась назад");
    }

    public void leanOn(WardrobeDoor wardrobeDoor) {
        System.out.println(this + " прислонилась к " + wardrobeDoor);
    }

    public void blinkEyes() {
        System.out.println(this + " опускала веки, словно проверяя себя, не обман ли это зрения");
    }

    public void respondNothing() {
        System.out.println(this + " на это ничего не ответила");
    }
}