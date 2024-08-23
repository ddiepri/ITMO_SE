package characters;

import architecture.items.RoomItem;
import interfaces.Flyable;
import interfaces.Lockable;

public class HousekeeperTamer extends Character implements Flyable {

    private int speed = -1; 

    public HousekeeperTamer() {
        super("укротитель домомучительниц");
    }

    @Override
    public void flyIn(RoomItem location) {
        if (speed < 0) {
            System.out.println(this + " явно влетает в квартиру через " + location);
        } else {
            System.out.println(this + " явно влетает через " + location + " со скоростью " + speed + " км/ч");
        }
    }

    @Override
    public void flyOut() {
        System.out.println(this + " вылетает");
    }

    @Override
    public void setSpeed(int speed) {
        if (speed < 0) {
            System.out.println("Скорость не может быть отрицательной");
            return; 
        }
        this.speed = speed;
        System.out.println(this + " установил скорость полета на " + speed + " км/ч");
    }

    public void lock(Lockable lockableObject) {
        lockableObject.lock();
    }

    public void helpUnderstand() {
        System.out.println(this + " помогает понять на собственном опыте");
    }

    public void demonstrateLockedExperience() {
        System.out.println(this + " демонстрирует, что значит сидеть взаперти");
    }
}