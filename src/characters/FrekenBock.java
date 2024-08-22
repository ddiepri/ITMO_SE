package characters;

import interfaces.Thinkable;


public class FrekenBock extends Character implements Thinkable {

    public FrekenBock() {
        super("Фрекен Бок");
    }

    public void respondNothing() {
        System.out.println(this + " на это ничего не ответила");
    }

    public void stand() {
        System.out.print(this + " стоит");
    }

    @Override
    public void think() {
        System.out.println(this + " о чем-то думает");
    }
}