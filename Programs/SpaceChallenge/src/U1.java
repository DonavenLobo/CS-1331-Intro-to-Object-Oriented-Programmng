public class U1 extends Rocket {
    int RocketCost = 100000000;
    double RocketWeight = 10;
    final double MaxWeight = 18;
    final double CargoLimit = MaxWeight - RocketWeight;

    public boolean launch() {
        double explosionChance = 5 * (CargoWeight/CargoLimit);
        return true;
    }
    public boolean land() {
        double explosionChance = 1 * (CargoWeight/CargoLimit);
        return true;
    }

}
