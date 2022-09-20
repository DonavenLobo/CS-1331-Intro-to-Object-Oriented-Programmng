//I worked on the homework assignment alone, using only course materials.

/**
 * This parent class represents a parent Bender class
 * @author Donaven Lobo
 * @version 1.0
 */

public abstract class Bender {
    private String name;
    private String element;
    private int strengthLevel;
    private int health;

    /**
     * This is the Main constructor for the benders
     * @param name takes in the name of a bender
     * @param element takes in the element of a bender
     * @param strengthLevel takes in the set strength level of a bender
     * @param health takes in the initial health of a bender
     */
    protected Bender(String name, String element, int strengthLevel, int health) {
        this.name = name;
        this.element = element;
        this.strengthLevel = strengthLevel;
        if (health > 0) {
            this.health = health;
        } else {
            this.health = 0;
        }
    }


    /**
     * Method to increase the health of a bender object
     * @param healthAid amount you want a benders health to increase by
     */
    public void healthIncrease(int healthAid) {
        if (this.health > 0) {
            this.health += healthAid;
        }
    }

    /**
     * Abstract method for bender attacks
     * @param opponent the opposing bender object you want to attack
     */
    public abstract void attack(Bender opponent);

    /**
     * Checks to see if two benders are the same
     * @param other the bender you are comparing with
     * @return a boolean value on whether they are equal
     */
    public boolean equals(Object other) {
        return (this.name == ((Bender) other).getName() && this.element == ((Bender) other).getElement()
                && this.strengthLevel == ((Bender) other).getStrengthLevel()
                && this.health == ((Bender) other).getHealth());
    }

    /**
     * Formats a statement on a given bender
     * @return a string about a bender
     */
    public String toString() {
        return String.format("My name is %s. I have control over %s. My strength level is %d "
                + "and my current health is %d.", this.name, this.element, this.strengthLevel, this.health);
    }

    /**
     * Getter method for name
     * @return the name of the bender
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for the element of a bender
     * @return the element of the bender
     */
    public String getElement() {
        return element;
    }

    /**
     * Getter method for health
     * @return the health of the bender
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter method for strength level
     * @return the strength level of the bender
     */
    public int getStrengthLevel() {
        return strengthLevel;
    }

    /**
     * Setter method for health
     * @param health an updated health
     */
    public void setHealth(int health) {
        if (health > 0) {
            this.health = health;
        } else {
            this.health = 0;
        }
    }

    /**
     * Setter method for strength level
     * @param strengthLevel an updated strength level
     */
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }
}
