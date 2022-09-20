public class Rocket implements SpaceShip {
    public boolean launch() {
        return true;
    }
    public boolean land() {
        return true;
    }
    public boolean canCarry(Item item)  {
        double newWeight = this.RocketWeight + (item.weight / 907);
        if (newWeight > this.MaxWeight) {
            return false;
        } else {
            return true;
        }
    }
    public void carry(Item item) {
        this.RocketWeight += item.weight;
    }
}
