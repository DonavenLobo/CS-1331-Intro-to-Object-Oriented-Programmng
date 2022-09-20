/**
 * This class represents a non-checked Exception for invalid pets
 * @author Donaven Lobo
 * @version 1.0
 */
public class InvalidPetException extends RuntimeException {
    /**
     * Main Constructor for the exception
     * @param s the error message
     */
    public InvalidPetException(String s) {
        super(s);
    }

    /**
     * Chained Constructor for the exception
     */
    public InvalidPetException() {
        this("Your pet is invalid!");
    }
}
