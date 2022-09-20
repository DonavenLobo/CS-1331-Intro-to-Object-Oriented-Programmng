//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Class represents a Clinic
 * @author Donaven Lobo
 * @version 1.0
 */
public class Clinic {
    private File patientFile;
    private static int day;

    /**
     * Main Constructor for the clinic class
     * @param file the file object containing patient information
     */
    public Clinic(File file) {
        this.patientFile = file;
        day = 1;
    }

    /**
     * Chained to the main constructor
     * @param fileName the file path containing the csv file
     */
    public Clinic(String fileName) {
        this(new File(fileName));
    }

    /**
     * Method that simulates a day of appointments with pets
     * @param f the file containing the appointment info
     * @return a string with updated patient info
     * @throws FileNotFoundException due to reading an input file
     */
    public String nextDay(File f) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner scanFile = new Scanner(f);
        String currLine;
        String output = "";
        while (scanFile.hasNextLine()) {
            currLine = scanFile.nextLine();
            String[] lineSplit = currLine.split(",");
            Pet currPet;
            if (!(lineSplit[1].equals("Dog") || lineSplit[1].equals("Cat"))) {
                throw new InvalidPetException();
            }
            System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", lineSplit[0]
                    , lineSplit[1], lineSplit[3], lineSplit[0]);
            boolean check = false;
            double health = 0.0;
            int painLevel = 0;
            while (!check) {
                try {
                    health = input.nextDouble();
                    check = true;
                } catch (RuntimeException e) {
                    input.nextLine();
                    System.out.println("Please enter a number");
                    System.out.printf("What is the health of %s?\n", lineSplit[0]);
                }
            }
            System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", lineSplit[0]);
            check = false;
            while (!check) {
                try {
                    painLevel = input.nextInt();
                    check = true;
                } catch (RuntimeException e) {
                    input.nextLine();
                    System.out.println("Please enter a number");
                    System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", lineSplit[0]);
                }
            }
            if (lineSplit[1].equals("Dog")) {
                currPet = new Dog(lineSplit[0], health, painLevel, Double.parseDouble(lineSplit[2]));
            } else {
                currPet = new Cat(lineSplit[0], health, painLevel, Integer.parseInt(lineSplit[2]));
            }

            currPet.speak();
            health = currPet.getHealth();
            painLevel = currPet.getPainLevel();
            int appointmentTime = currPet.treat();
            String newTimeOut = addTime(lineSplit[3], appointmentTime);
            String petDetails = String.format("%s,%s,%s,Day %d,%s,%s,%.1f,%d\n", currPet.getName(), lineSplit[1]
                    , lineSplit[2], day, lineSplit[3], newTimeOut, health, painLevel);

            output = output + petDetails;
        }
        return output;
    }

    /**
     * Chained to main nextDay file
     * @param fileName String path to file containing appointment info
     * @return String value of updated patient info
     * @throws FileNotFoundException due to reading an input file
     */
    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    /**
     * Method to add updated health data to patient file
     * @param patientInfo new patient info
     * @return a boolean on whether the update was successful or not
     */
    public boolean addToFile(String patientInfo) {
        PrintWriter filePrint;
        String[] patientInfoSplit = patientInfo.split(",");
        String patientName = patientInfoSplit[0];
        String appendedFile = "";
        boolean oldPatient = false;
        try {
            Scanner fileReader = new Scanner(patientFile);
            while (fileReader.hasNextLine()) {
                String currLine = fileReader.nextLine();
                String[] currLineSplit = currLine.split(",");
                if (patientName.equals(currLineSplit[0])) {
                    for (int i = 1; i < 8; i++) {
                        currLineSplit[i] = patientInfoSplit[i];
                    }
                    oldPatient = true;
                }
                appendedFile = appendedFile + String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", currLineSplit[0]
                        , currLineSplit[1], currLineSplit[2],  currLineSplit[3], currLineSplit[4], currLineSplit[5]
                        ,  currLineSplit[6], currLineSplit[7]);
            }
            if (!oldPatient) {
                appendedFile = appendedFile + patientInfo;
            }
            filePrint = new PrintWriter(patientFile);
            filePrint.print(appendedFile);
            filePrint.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    /**
     * Method to add time in military time
     * @param timeIn the initial time
     * @param treatmentTime the number of minutes the treatment takes
     * @return a String of the new time after the appointment
     */
    private String addTime(String timeIn, int treatmentTime) {
        int hours = Integer.parseInt(timeIn.substring(0, 2));
        int mins = Integer.parseInt(timeIn.substring(2));
        int totalMins = mins + treatmentTime;
        String minString;
        String hourString;
        while (totalMins >= 60) {
            totalMins -= 60;
            hours++;
        }
        if (totalMins < 10) {
            minString = "0" + totalMins;
        } else {
            minString = "" + totalMins;
        }
        if (hours < 10) {
            hourString = "0" + hours;
        } else {
            hourString = "" + hours;
        }
        return hourString + minString;
    }

}
