//I worked on the homework assignment alone, using only course materials.
/**
 * @author Donaven Lobo
 * @version 1.0
 */
public class Pond {
    /**
     * Main method
     * @param args command line inputs
     */
    public static void main(String[] args) {
        /** Frog Objects */
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6,  5);
        Frog donny = new Frog("Donny", 3, 20);

        /** Fly Objects */
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly shim = new Fly();

        /** Tasks */
        Frog.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());
        peepo.eat(fly2);
        System.out.println(fly2.toString());
        peepo.grow(8);
        peepo.eat(fly2);
        System.out.println(fly2.toString());
        System.out.println(peepo.toString());
        System.out.println(donny.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}
