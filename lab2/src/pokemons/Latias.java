package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import moves.status.Swagger;
import moves.status.Rest;


public class Latias extends Pokemon {
    public Latias(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC, Type.DRAGON);
        setStats(80, 80, 90, 110, 130, 110);
        setMove(new Swagger(), new Rest());
    }
}