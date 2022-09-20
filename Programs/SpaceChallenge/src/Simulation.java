import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class Simulation {
    ArrayList loadItems(String textFile) throws FileNotFoundException {
        File importFile = new File(textFile);
        Scanner itemFile = new Scanner(importFile);
        ArrayList items = new ArrayList();
        itemFile.useDelimiter("=");
        while (itemFile.hasNextLine()) {
            items.add(itemFile.next());
            items.add(itemFile.next());
        }
        return items;
    }

    ArrayList loadU1(ArrayList items) {
        ArrayList rocketFleetU1 = new ArrayList();
        for (int i = 0; i < items.size(); i += 2) {
            if (Rocket.canCarry()) {


            }
        }
        return rocketFleetU1;
    }

    ArrayList loadU2(ArrayList items) {
        ArrayList rocketFleetU2 = new ArrayList();
        for (int i = 0; i < items.size(); i += 2) {
            if (Rocket.canCarry()) {


            }
        }
        return rocketFleetU2;
    }
}
