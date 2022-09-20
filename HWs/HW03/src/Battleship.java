//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner; /** Imports Scanner from utility package */
public class Battleship {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); /** Creates a global scanner that can be used by
         multiple methods */

        System.out.print("Welcome to Battleship!\n\n"); /** Game prompt */

        /** Player 1 set-up */
        System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
        char[][] player1 = createBoard(input);
        char[][] player1Attempts = boardTemplate();
        int player1Health = 5;
        printBattleShip(player1);
        playerFilter();

        /** Player 2 set-up */
        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
        char[][] player2 = createBoard(input);
        char[][] player2Attempts = boardTemplate();
        int player2Health = 5;
        printBattleShip(player2);
        playerFilter();

        while (true) {

            /** Player 1's turn */
            System.out.println("Player 1, enter hit row/column:");
            int[] player1Coordinates = getCoordinates(player1Attempts, input);
            player1Attempts = updateAttempts(player1Coordinates, player1Attempts, player2, 1, 2);
            player2 = updateBoard(player1Coordinates, player2);
            player2Health -= checkHealth(player1Coordinates, player1Attempts);
            printBattleShip(player1Attempts);
            if (player2Health == 0) { /** Case if player 1 destroys all of players 2's ships */
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                System.out.print("\nFinal boards:\n\n");
                printBattleShip(player1);
                System.out.println();
                printBattleShip(player2);
                break; /** To exit the loop */
            } else {
                System.out.println();
            }

            /** Player 2's turn */
            System.out.println("Player 2, enter hit row/column:");
            int[] player2Coordinates = getCoordinates(player2Attempts, input);
            player2Attempts = updateAttempts(player2Coordinates, player2Attempts, player1, 2, 1);
            player1 = updateBoard(player2Coordinates, player1);
            player1Health -= checkHealth(player2Coordinates, player2Attempts);
            printBattleShip(player2Attempts);
            if (player1Health == 0) { /** Case if player 2 destroys all of players 1's ships */
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
                System.out.print("\nFinal boards:\n\n");
                printBattleShip(player1);
                System.out.println();
                printBattleShip(player2);
                break; /** To exit the loop */
            } else {
                System.out.println();
            }
        }
    }

    public static char[][] createBoard(Scanner input) { /** Method to create initial boards for players */
        boolean validInput;
        char[][] playerBoard = boardTemplate();

        for (int i = 0; i < 5; i++) {
            validInput = false;
            do {
                System.out.printf("Enter ship %d location:\n", i + 1);
                int row = input.nextInt();
                int col = input.nextInt();
                if (row >= 0 && row < 5 && col >= 0 && col < 5) {
                    if (playerBoard[row][col] == '-') {
                        validInput = true;
                        playerBoard[row][col] = '@';
                    } else {
                        System.out.println("You already have a ship there. Choose different coordinates.");
                    }
                } else {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            } while (!validInput);
        }
        return playerBoard;
    }

    public static int[] getCoordinates(char[][] attemptBoard, Scanner input) { /** Method to check if entered
                                                                                coordinates are valid */
        boolean validInput = false;
        int[] coords = new int[2];
        do {
            int row = input.nextInt();
            int col = input.nextInt();
            if (row >= 0 && row < 5 && col >= 0 && col < 5) {
                if (!(attemptBoard[row][col] == 'O' || attemptBoard[row][col] == 'X')) {
                    validInput = true;
                    coords[0] = row;
                    coords[1] = col;
                } else {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                }
            } else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
        } while (!validInput);
        return coords;
    }

    public static char[][] updateAttempts(int[] coords, char[][] attemptBoard, char[][] opponentBoard, int playerID,
                                          int opponentID) { /** Check if hit, updates the players attempt board */
        if (opponentBoard[coords[0]][coords[1]] == '@') {
            System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!\n", playerID, opponentID);
            attemptBoard[coords[0]][coords[1]] = 'X';
        } else {
            System.out.printf("PLAYER %d MISSED!\n", playerID);
            attemptBoard[coords[0]][coords[1]] = 'O';
        }
        return attemptBoard;
    }

    public static char[][] updateBoard(int[] coords, char[][] opponentBoard) { /** Updates opponents board after turn */
        if (opponentBoard[coords[0]][coords[1]] == '@') {
            opponentBoard[coords[0]][coords[1]] = 'X';
        } else {
            opponentBoard[coords[0]][coords[1]] = 'O';
        }
        return opponentBoard;
    }

    public static void playerFilter() { /** Creates 100 blank lines */
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static int checkHealth(int[] coords , char[][] board) { /** Gets value to update health of each player */
        if (board[coords[0]][coords[1]] == 'X') {
            return (int) 1;
        } else {
            return (int) 0;
        }
    }

    public static char[][] boardTemplate() { /** returns the initial board */

        char[][] board = {{'-', '-' , '-' , '-' , '-'}, {'-', '-' , '-' , '-' , '-'}, {'-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-'}, {'-', '-', '-', '-', '-'}};

        return board;
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }
}
