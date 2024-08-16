package moves.physical;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Pokemon;

/*
  Take Down deals damage, but the user receives 1⁄4 of the damage it inflicted in recoil. 
 */

public class TakeDown extends PhysicalMove {
    public TakeDown() {
        super(Type.NORMAL, 90, 85);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage); 
    }

    @Override
    protected void applySelfDamage(Pokemon att, double damage) {
        double recoilDamage = damage / 4; 
        att.setMod(Stat.HP, (int) Math.round(-recoilDamage)); 
    }

    @Override
    protected String describe() {
        return "does " + getClass().getSimpleName();
    }
}