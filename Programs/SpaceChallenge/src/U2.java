public class U2 extends Rocket {
    int RocketCost = 120000000;
    double RocketWeight = 18;
    final double MaxWeight = 29;
    final double CargoLimit = MaxWeight - RocketWeight;

    public boolean launch() {
        double explosionChance = 4 * (CargoWeight/CargoLimit);
        return true;
    }
    public boolean land() {
        double explosionChance = 8 * (CargoWeight/CargoLimit);
        return true;
    }
}
