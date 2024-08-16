package moves.status;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;

/*
  User sleeps for 2 turns, but user is fully healed.
 */

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect sleepForTwoTurns = new Effect().condition(Status.SLEEP).turns(2);
        p.addEffect(sleepForTwoTurns);

        p.setMod(Stat.HP, (int) Math.round(p.getStat(Stat.HP) - p.getHP()));
    }

    @Override
    protected String describe() {
        return "does " + getClass().getSimpleName();
    }
}