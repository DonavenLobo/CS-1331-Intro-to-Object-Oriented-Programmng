import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {
        int randNumber = (int)(Math.random() * 100) + 1;
        System.out.print("I have randomly chosen a number between 1 and 100.\nTry and guess it.\n");
        Scanner in = new Scanner(System.in);
        boolean win = false;

        for (int i = 10; i > 0; i--) {
            System.out.printf("You have %d guesses left! Guess a number:\n", i);
            int userGuess = in.nextInt();
            if (userGuess == randNumber) {
                System.out.printf("The number %d is correct! It only took you %d guesses!\n", userGuess, (11-i));
                win = true;
                break;
            } else {
                System.out.printf("Oh no! %d is not the number I am thinking of...\n", userGuess);
                if (randNumber > userGuess) {
                    System.out.printf("The number I am thinking of is greater than %d.\n", userGuess);
                } else {
                    System.out.printf("The number I am thinking of is less than %d.\n", userGuess);
                }
            }
        }
        if (!win) {
            System.out.printf("Sorry you have ran out of guesses. The number I was thinking of was %d\n", randNumber);
        }

    }
}
