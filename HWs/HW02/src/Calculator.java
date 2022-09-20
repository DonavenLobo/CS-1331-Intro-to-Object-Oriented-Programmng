//I worked on the homework assignment alone, using only course materials


import java.util.Scanner; /** Imports Scanner method to enable user inputs in the program */
public class Calculator {
    public static void main(String[] args) { /** Program locally defined in the main function */
        System.out.println("List of operations: add subtract multiply divide alphabetize"); /** Prints out the operation
         menu for user selection */
        Scanner input = new Scanner(System.in); /** Creates a scanner object to take in user inputs later on */
        System.out.println("Enter an operation:"); /** Prints the prompt for the user input */
        String selection = input.next(); /** Gets input of what operation the user wants to perform */
        selection = selection.toLowerCase(); /** Converts the input string to all lower case */
        switch (selection) { /** Switch statement to check user input */
        case "add":
            System.out.println("Enter two integers:");
            if (input.hasNextInt()) { /** Checks if first input is correct data type */
                int add1 = input.nextInt(); /** Stores first input in according variable */
                if (input.hasNextInt()) { /** Checks if second input is correct data type */
                    int add2 = input.nextInt(); /** Stores second input in according variable */
                    int addAnswer = add1 + add2;
                    System.out.println("Answer: " + addAnswer);
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
            } else {
                System.out.println("Invalid input entered. Terminating...");
            }
            break;
        /** All others cases follow similar format and logic as above */
        case "subtract":
            System.out.println("Enter two integers:");
            if (input.hasNextInt()) {
                int sub1 = input.nextInt();
                if (input.hasNextInt()) {
                    int sub2 = input.nextInt();
                    int subAnswer = sub1 - sub2;
                    System.out.println("Answer: " + subAnswer);
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
            } else {
                System.out.println("Invalid input entered. Terminating...");
            }
            break;
        case "multiply":
            System.out.println("Enter two doubles:");
            if (input.hasNextDouble()) {
                double mult1 = input.nextDouble();
                if (input.hasNextDouble()) {
                    double mult2 = input.nextDouble();
                    double multAnswer = mult1 * mult2;
                    System.out.printf("Answer: %.2f", multAnswer);
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
            } else {
                System.out.println("Invalid input entered. Terminating...");
            }
            break;
        case "divide":
            System.out.println("Enter two doubles:");
            if (input.hasNextDouble()) {
                double div1 = input.nextDouble();
                if (input.hasNextDouble()) {
                    double div2 = input.nextDouble();
                    if (div2 != 0) {
                        double divAnswer = div1 / div2;
                        System.out.printf("Answer: %.2f", divAnswer);
                    } else {
                        System.out.println("Invalid input entered. Terminating...");
                    }

                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
            } else {
                System.out.println("Invalid input entered. Terminating...");
            }
            break;
        case "alphabetize":
            System.out.println("Enter two words:");
            if (input.hasNext()) {
                String word1 = input.next();
                if (input.hasNext()) {
                    String word2 = input.next();
                    int comparisonValue = word1.toLowerCase().compareTo(word2.toLowerCase());
                    if (comparisonValue < 0) {
                        System.out.printf("Answer: %s comes before %s alphabetically.", word1, word2);
                    } else if (comparisonValue > 0) {
                        System.out.printf("Answer: %s comes before %s alphabetically.", word2, word1);
                    } else {
                        System.out.println("Answer: Chicken or Egg.");
                    }
                } else {
                    System.out.println("Invalid input entered. Terminating...");
                }
            } else {
                System.out.println("Invalid input entered. Terminating...");
            }
            break;
        default: /** if user inputs incorrect option */
            System.out.println("Invalid input entered. Terminating...");
            break;
        }
    }
}
