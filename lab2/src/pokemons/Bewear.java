package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import moves.physical.ShadowClaw;


public class Bewear extends Stufful {
    public Bewear(String name, int level) {
        super(name, level);
        setType(Type.NORMAL, Type.FIGHTING);
        setStats(120, 125, 80, 55, 60, 60);
        addMove(new ShadowClaw());
    }
}