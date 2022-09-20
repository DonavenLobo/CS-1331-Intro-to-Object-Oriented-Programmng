/**
 * This Class represents a fly object
 * @author Donaven Lobo
 * @version 1.0
 */

public class Fly {

    /** Attributes */
    private double mass;
    private double speed;

    /**
     * Main constructor for the fly class
     * @param mass is the mass of a given fly
     * @param speed is the set speed of a given fly
     */
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    /**
     * Constructor with single parameter chained to main parameter
     * @param mass is the mass of a given fly
     */
    public Fly(double mass) {
        this(mass, 10);
    }

    /**
     * Default Constructor - chained to the main constructor
     */
    public Fly() {
        this(5);
    }

    /**
     * Getter method returning mass
     * @return the mass of the fly
     */
    public double getMass() {
        return mass;
    }

    /**
     * Getter method returning the speed
     * @return the speed of the fly
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Method to set a new mass of a fly
     * @param mass gives us the new mass we want to set
     */
    public void setMass(double mass) {
        if (mass >= 0) {
            this.mass = mass;
        }
    }

    /**
     *  Method to set the new speed of the fly
     * @param speed gives us the new speed we want to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Overrides the default object toString method
     * @return a String with formatted sentence
     */
    public String toString() {
        String sentence;
        if (mass == 0) {
            sentence = String.format("I’m dead, but I used to be a fly with a speed of %.2f.", speed);
        } else {
            sentence = String.format("I’m a speedy fly with %.2f speed and %.2f mass.", speed, mass);
        }
        return sentence;
    }

    /**
     * Method to simulate growth of a fly
     * @param addedMass states how much mass the fly puts on
     */
    public void grow(int addedMass) {
        for (int i = 0; i < addedMass; i++) {
            if (mass < 20) {
                this.speed += 1;
            } else {
                this.speed -= 0.5;
            }
            this.mass += 1;
        }
    }

    /**
     * Method to check if the fly is dead or not
     * @return a boolean value stating whether the fly is dead or not
     */
    public boolean isDead() {
        return mass == 0;
    }
    
}

