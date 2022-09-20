/**
 * This class represents a Dog object
 * @author Donaven Lobo
 * @version 1.0
 */
public class Dog extends Pet {
    private double droolRate;

    /**
     * Main Dog Constructor
     * @param name the dogs name
     * @param health the dogs health
     * @param painLevel the dogs pain level
     * @param droolRate the dogs drool rate
     */
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }

    /**
     * Chained Dog Constructor
     * @param name the dogs name
     * @param health the dogs health
     * @param painLevel the dogs pain level
     */
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    /**
     * Getter method for the dogs drool rate
     * @return how much the dog drools
     */
    public double getDroolRate() {
        return this.droolRate;
    }

    /**
     * Sets concrete method to treat dog
     * @return the number of minutes that the dogs treatment will take
     */
    public int treat() {
        double time;
        if (this.droolRate < 3.5) {
            time = (this.getPainLevel() * 2) / this.getHealth();
        } else if (droolRate >= 3.5 && droolRate <= 7.5) {
            time = this.getPainLevel() / this.getHealth();
        } else {
            time = this.getPainLevel() / (this.getHealth() * 2);
        }
        this.heal();
        return (int) Math.ceil(time);
    }

    /**
     * Overrides pets speak method for dog
     */
    public void speak() {
        String message;

        super.speak();
        message = "bark ".repeat(this.getPainLevel());
        message = message.trim();
        if (this.getPainLevel() > 5) {
            message = message.toUpperCase();
        }
        System.out.println(message);
    }

    /**
     * Checks if two Dog objects are equal
     * @param o an object that is a dog
     * @return a boolean value on whether the two dogs are the same
     */
    public boolean equals(Object o) {
        return this.droolRate == ((Dog) o).getDroolRate() && super.equals(o);
    }
}
