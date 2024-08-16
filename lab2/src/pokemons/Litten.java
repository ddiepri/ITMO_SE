package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import moves.status.Rest;
import moves.status.Swagger;


public class Litten extends Pokemon {
    public Litten(String name, int level) {
        super(name, level);
        setType(Type.FIRE);
        setStats(45, 65, 40, 60, 40, 70);
        setMove(new Swagger(), new Rest());
    }
}