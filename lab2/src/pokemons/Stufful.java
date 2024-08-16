package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import moves.status.DoubleTeam;
import moves.status.Swagger;
import moves.status.Rest;


public class Stufful extends Pokemon {
    public Stufful(String name, int level) {
        super(name, level);
        setType(Type.NORMAL, Type.FIGHTING);
        setStats(70, 75, 50, 45, 50, 50);
        setMove(new Swagger(), new Rest(), new DoubleTeam());
    }
}