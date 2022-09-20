/**
 * This is a Airbender Class
 * @author Donaven Lobo
 * @version 1.0
 */
public class AirBender extends Bender {
    private boolean avatar;

    /**
     * Main constructor for Airbenders
     * @param name the name of the airbender
     * @param strengthLevel the strength level of the airbender
     * @param health the health
     * @param avatar whether or not the airbender is an avatar
     */
    public AirBender(String name, int strengthLevel, int health, boolean avatar) {
        super(name, "Air", strengthLevel, health);
        this.avatar = avatar;
    }

    /**
     * Chained to main constructor with default values
     * @param name the name of the airbender
     */
    public AirBender(String name) {
        this(name, 40, 35, false);
    }

    /**
     * Specific attack for airbenders
     * @param opponent the opposing bender object you want to attack
     */
    public void attack(Bender opponent) {
        if (this.getHealth() >= 0) {
            opponent.setHealth(opponent.getHealth() - (this.getStrengthLevel() / 2));
        }
        if (opponent.getHealth() < 0) {
            opponent.setHealth(0);
        }
    }

    /**
     * Checks if two airbenders have the same health
     * @param partner another airbender object
     * @return whether or not they have the same health
     */
    public boolean spiritualProjection(Bender partner) {
        return (this.getHealth() == partner.getHealth());
    }

    /**
     * Different outcomes based on the avatars element and the opponent
     * @param element the avatars element
     * @param bender the opponent bender
     */
    public void avatarState(String element, Bender bender) {
        if (this.avatar) {
            switch (element) {
            case "Earth":
                bender.setHealth(bender.getHealth() / 2);
                break;
            case "Fire":
                bender.setStrengthLevel(bender.getStrengthLevel() - 10);
                if (bender.getStrengthLevel() < 10) {
                    bender.setStrengthLevel(0);
                }
                break;
            case "Air":
                if (bender.getStrengthLevel() < 15) {
                    bender.setStrengthLevel(0);
                }
                break;
            default:
                if (bender.getStrengthLevel() < 15 && bender.getHealth() < 5) {
                    bender.setHealth(0);
                }
                break;
            }
        }
    }
}
