import ru.ifmo.se.pokemon.*;
import pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Pokemon fp1 = new Litten("Litten", 0);
        Pokemon fp2 = new Torracat("Torracat", 0);
        Pokemon fp3 = new Incineroar("Incineroar", 0);

        battle.addAlly(fp1);
        battle.addAlly(fp2);
        battle.addAlly(fp3);

        Pokemon sp1 = new Bewear("Bewear", 0);
        Pokemon sp2 = new Stufful("Stufful", 0);
        Pokemon sp3 = new Latias("Latias", 0);

        battle.addFoe(sp1);
        battle.addFoe(sp2);
        battle.addFoe(sp3);

        battle.go();
    }
}