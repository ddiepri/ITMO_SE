package moves.special;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

/*
  Giga Drain deals damage and the user will recover 50% of the HP drained.
 */

public class GigaDrain extends SpecialMove {
    private double damageDealt; 

    public GigaDrain() {
        super(Type.GRASS, 75, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage); 
        this.damageDealt = damage; 
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        double healedHP = this.damageDealt * 0.5;
        p.setMod(Stat.HP, (int)Math.round(healedHP));
    }

    @Override
    protected String describe() {
        return "does " + getClass().getSimpleName();
    }
}