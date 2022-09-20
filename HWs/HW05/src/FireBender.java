/**
 * This is a Firebender Class
 * @author Donaven Lobo
 * @version 1.0
 */
public class FireBender extends Bender implements PowerUp {
    private int fireStrength;
    private boolean hasArmy;

    /**
     * Main constructor for Firebenders
     * @param name the name of the firebender
     * @param strengthLevel the strength level
     * @param health fire benders intial health
     * @param fireStrength firebenders fire strength
     * @param hasArmy whether the firebender has an army or not
     */
    public FireBender(String name, int strengthLevel, int health, int fireStrength, boolean hasArmy) {
        super(name, "Fire", strengthLevel, health);
        this.fireStrength = fireStrength;
        this.hasArmy = hasArmy;
    }

    /**
     * Constructor chained to the main constructor with default values
     * @param name the name of the firebender
     */
    public FireBender(String name) {
        this(name, 30, 15, 15, true);
    }

    /**
     * Method to update firebender attributes if it has an army
     */
    public void fireArmy() {
        if (hasArmy) {
            this.setHealth(this.getHealth() * 2);
            this.fireStrength = this.fireStrength * 3;
        }
    }

    /**
     * Specific attack for firebenders
     * @param opponent the opposing bender object you want to attack
     */
    public void attack(Bender opponent) {
        if (this.getHealth() >= 5) {
            opponent.setHealth(opponent.getHealth() - (this.getStrengthLevel() * this.fireStrength));
        }
    }

    /**
     * Checks to see if two firebenders are equal
     * @param bender another bender object
     * @return a boolean value on whethe the two objects are equal or not
     */
    public boolean equals(Object bender) {
        boolean check = this.getFireStrength() == ((FireBender) bender).getFireStrength() && super.equals(bender);
        return check;
    }

    /**
     * Statement about firebender
     * @return description of current firebender
     */
    public String toString() {
        String sentence = super.toString();
        sentence = sentence + String.format(" My fire strength level is %d.", this.fireStrength);
        return sentence;
    }

    /**
     * Getter for the fire strength
     * @return the fire strength
     */
    public int getFireStrength() {
        return fireStrength;
    }
}
