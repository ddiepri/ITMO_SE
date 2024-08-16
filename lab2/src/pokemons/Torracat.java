package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import moves.special.GigaDrain;


public class Torracat extends Litten {
    public Torracat(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(65, 85, 50, 80, 50, 90);
        addMove(new GigaDrain());
    }
}