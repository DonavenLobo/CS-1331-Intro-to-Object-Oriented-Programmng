public class BenderDriver {
    public static void main(String[] args) {
        /**
        FireBender fire = new FireBender("Donny");
        AirBender air = new AirBender("Julian");
        System.out.println(fire);
        System.out.println(air);
        System.out.println();

        fire.attack(air);
        System.out.println(fire);
        System.out.println(air);
        System.out.println();

        air.avatarState("Air", fire);
        System.out.println(fire);
        System.out.println(air);
        System.out.println();

        fire.fireArmy();
        System.out.println(fire);
        System.out.println(air);
        System.out.println();

        fire.healthIncrease(10);
        System.out.println(fire);
        System.out.println(air);
        System.out.println();

        PowerUp.strengthDoubles(fire);
        System.out.println(fire);
        System.out.println();
         */

        AirBender airy = new AirBender("Airy Boy", 100, 100, true);
        FireBender firey = new FireBender("Fire Boy" , 10 , 100 , 5, true);
        FireBender fire = new FireBender("Donny");
        AirBender air = new AirBender("Julian");
        System.out.println("Original Values set:");
        System.out.println(airy);
        System.out.println(firey);
        System.out.println(fire);
        System.out.println(air);
        System.out.println();

        airy.attack(firey);
        System.out.println("After Airy Boy attacks Firey boy");
        System.out.println(airy);
        System.out.println(firey);
        System.out.println();

        firey.attack(airy);
        System.out.println("Firey Boy attacks Airy boy");
        System.out.println(airy);
        System.out.println(firey);
        System.out.println();

        System.out.println("The spiritual projection between airy and firey:");
        System.out.println(airy.spiritualProjection(firey));
        System.out.println();

        airy.avatarState("Water", firey);
        System.out.println("Avatar state method:");
        System.out.println(airy);
        System.out.println(firey);
        System.out.println();

        firey.fireArmy();
        System.out.println("Fire Army method:");
        System.out.println(airy);
        System.out.println(firey);
        System.out.println();

        System.out.println("Checks to see if two fire objects are equal");
        System.out.println(firey.equals(fire));

        System.out.println("Checks to see if two air objects are equal");
        System.out.println(air.equals(air));
        System.out.println();

        System.out.println("Tries out the strength doubles method");
        PowerUp.strengthDoubles(firey);
        System.out.println(firey);
        System.out.println();

    }
}
