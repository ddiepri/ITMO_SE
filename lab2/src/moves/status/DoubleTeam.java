package moves.status;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

/*
  Double Team raises the user's Evasiveness by one stage, thus making the user more difficult to hit.
 */

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.EVASION, +1); 
    }

    @Override
    protected String describe() {
        return "does " + getClass().getSimpleName();
    }
}