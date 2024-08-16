package moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;

/*
  Shadow Claw deals damage and has an increased critical hit ratio (1⁄8 instead of 1⁄24).
 */

public class ShadowClaw extends PhysicalMove {
    public ShadowClaw() {
        super(Type.GHOST, 70, 100);
    }

    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        if (Math.random() < (att.getStat(Stat.SPEED) / 512.0) * 3) {
            return 2.0; 
        } else {
            return 1.0; 
        }
    }

    @Override
    protected String describe() {
        return "does " + getClass().getSimpleName();
    }
}