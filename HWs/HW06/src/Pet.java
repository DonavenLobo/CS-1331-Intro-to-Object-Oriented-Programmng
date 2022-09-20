/**
 * This abstract class represents a general pet object
 * @author Donaven Lobo
 * @version 1.0
 */

public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    /**
     * Main Constructor for pet objects
     * @param name The name of the pet
     * @param health The health of the pet
     * @param painLevel The pain level of the pet
     */
    public Pet(String name, double health, int painLevel) {
        this.name = name;

        if (health > 1.0) {
            this.health = 1.0;
        } else if (health < 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }
        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 0) {
            this.painLevel = 0;
        } else {
            this.painLevel = painLevel;
        }
    }

    /**
     * Getter method for the pets name
     * @return the pets name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for the pets health
     * @return the pets health
     */
    public double getHealth() {
        return this.health;
    }

    /**
     * Getter method for the pets pain level
     * @return the pets pain level
     */
    public int getPainLevel() {
        return this.painLevel;
    }

    /**
     * Abstract method to treat pets
     * @return how many minutes the pet needs to be treated
     */
    public abstract int treat();

    /**
     * Method for the pet to speak
     */
    public void speak() {
        String message = String.format("Hello! My name is %s", this.name);
        if (painLevel > 5) {
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }

    /**
     * Overrides object equals method to make it more suited for pets
     * @param o an object that is a pet
     * @return a boolean value on whether or not the pets are equal
     */
    public boolean equals(Object o) {
        return this.name == ((Pet) o).getName();
    }

    /**
     * Method to heal a pet
     */
    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }

}
