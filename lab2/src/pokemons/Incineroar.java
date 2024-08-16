package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import moves.physical.TakeDown;


public class Incineroar extends Torracat {
    public Incineroar(String name, int level) {
        super(name, level);
        setType(Type.FIRE, Type.DARK);
        setStats(95, 115, 90, 80, 90, 60);
        addMove(new TakeDown());
    }
}
