package moves.status;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

/*
  Meditate raises the user's Attack by one stage.
 */

public class Meditate extends StatusMove {
    public Meditate() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, +1); 
    }

    @Override
    protected String describe() {
        return "does " + getClass().getSimpleName();
    }
}