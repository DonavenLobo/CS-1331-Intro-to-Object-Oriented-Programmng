/**
 * This class represents a Cat object
 * @author Donaven Lobo
 * @version 1.0
 */
public class Cat extends Pet {
    private int miceCaught;

    /**
     * Main Cat Constructor
     * @param name the name of the cat
     * @param health the health of the cat
     * @param painLevel the pain level of the cat
     * @param miceCaught the number of mice the cat caught
     */
    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }
    }

    /**
     * Chained Cat Constructor
     * @param name the name of the cat
     * @param health the health of the cat
     * @param painLevel the pain level of the cat
     */
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }

    /**
     * Getter method for the number of mice caught by a cat
     * @return the number of mice caught by a cat
     */
    public int getMiceCaught() {
        return this.miceCaught;
    }

    /**
     * Concrete method for how long to treat a Cat
     * @return the number of minutes the treatment will take
     */
    public int treat() {
        double minutes;
        if (this.miceCaught < 4) {
            minutes = (this.getPainLevel() * 2) / this.getHealth();
        } else if (this.miceCaught >= 4 && this.miceCaught <= 7) {
            minutes = this.getPainLevel() / this.getHealth();
        } else {
            minutes = this.getPainLevel() / (this.getHealth() * 2);
        }
        this.heal();
        return (int) Math.ceil(minutes);
    }

    /**
     * Overrides pet speak method to make it more specific for cats
     */
    public void speak() {
        String message;
        super.speak();
        message = "meow ".repeat(this.miceCaught);
        message = message.trim();
        if (this.getPainLevel() > 5) {
            message = message.toUpperCase();
        }
        System.out.println(message);
    }

    /**
     * Checks if two cat objects are equal
     * @param o an object that is a cat
     * @return a boolean value on whether the two cats are the same
     */
    public boolean equals(Object o) {
        return this.miceCaught == ((Cat) o).miceCaught && super.equals(o);
    }
}
