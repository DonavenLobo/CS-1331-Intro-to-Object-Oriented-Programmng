/**
 * This Class represents a frog object
 * @author Donaven Lobo
 * @version 1.0
 */

public class Frog {

    /** Attributes */
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    /**
     * Main constructor for the frog class
     * @param name states the name of a given frog
     * @param age states the age in months of a frog
     * @param tongueSpeed states the tongue speed of a frog
     */
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }

    /**
     * Constructor that takes in age in years - chained to the main constructor
     * @param name states the name of a given frog
     * @param ageInYears states the age in years of a frog
     * @param tongueSpeed states the tongue speed of a frog
     */
    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    /**
     * Contructor that only takes in a name of a frog
     * @param name states the name of a given frog
     */
    public Frog(String name) {
        this(name, 5, 5);
    }

    /**
     * Getter method to get the species of all frogs
     * @return the current set species
     */
    public static String getSpecies() {
        return species;
    }


    /**
     * Setter method to set the species of all frogs
     * @param newSpecies new species string
     */
    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    /**
     * Method to simulate the frog growing
     * @param months how many months you want the frog to grow by
     */
    public void grow(int months) {
        for (int i = 0; i < months; i++) {
            if (age < 12) {
                this.tongueSpeed += 1;
            } else if (age >= 30 && tongueSpeed > 5) {
                this.tongueSpeed -= 1;
            }
            age++;
        }
    }

    /**
     * Method override with no parameters, chained to the main method
     */
    public void grow() {
        grow(1);
    }

    /**
     * Method to simulate a frog attempting to eat a fly
     * @param fly a given fly that the frog is trying to eat
     */
    public void eat(Fly fly) {
        if (!fly.isDead()) {
            if (fly.getSpeed() < tongueSpeed) {
                if (fly.getMass() >= (double) (age * 0.5)) {
                    grow();
                }
                fly.setMass(0);
            } else {
                fly.grow(1);
            }
        }
    }

    /**
     * Overrides the default object toString method
     * @return a String with formatted sentence
     */
    public String toString() {
        String sentence;

        if (age <= 7) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }

        if (isFroglet) {
            sentence = String.format("My name is %s and I’m a rare froglet! I’m %d months old and "
                    + "my tongue has a speed of %.2f", name, age, tongueSpeed);
        } else {
            sentence = String.format("My name is %s and I’m a rare frog. I’m %d months old and "
                    + "my tongue has a speed of %.2f", name, age, tongueSpeed);
        }
        return sentence;
    }

}
