/**
 * This interface represents a power-up that can be inherited
 * @author Donaven Lobo
 * @version 1.0
 */
public interface PowerUp {
    /**
     * abstract method for fire types
     */
    void fireArmy();

    /**
     * concrete method to double the strength of a given bender
     * @param bender the bender you want to double the strength of
     */
    static void strengthDoubles(FireBender bender) {
        bender.setStrengthLevel(bender.getStrengthLevel() * 2);
    }
}
