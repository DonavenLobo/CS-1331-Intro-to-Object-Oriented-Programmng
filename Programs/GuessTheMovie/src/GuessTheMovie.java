
import java.io.File;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to 'Guess the movie name' game");
        File movieFile = new File("movies.txt");
        Scanner findNumLines =  new Scanner (movieFile);

        // calculating the file lines
        int lineCount=0;
        while(findNumLines.hasNextLine()) {
            lineCount++;
            findNumLines.nextLine();
        }

        // putting the movies names into array
        Scanner movieFileReader = new Scanner(movieFile);
        String [] moviesNames = new String [lineCount] ;
        for (int i = 0; i < moviesNames.length; i++) {
            moviesNames[i] = movieFileReader.nextLine();
        }

        // picking up a movie name
        int random = (int)(Math.random() * lineCount);
        String movieName = moviesNames[random];
        //System.out.println(movieName);

        // getting the movie name as dashes
        String dashedMovieName = "";
        for (int i = 0; i < movieName.length(); i++) {
            dashedMovieName += "-";
        }
        System.out.println(dashedMovieName);

        // putting the dashes into char array
        char [] nameChar = dashedMovieName.toCharArray();

        // user turn to guess
        Scanner user = new Scanner(System.in);
        int userTries = 10;
        try {
            // game conditions
            while (userTries > 0 && dashedMovieName.contains("-") == true) {
                // taking a char from user
                System.out.println("Enter a char in the movie name. \nYou have " + userTries + " tries left:");
                char userinput = user.nextLine().charAt(0);
                // the index number of the char entered inside the movie name
                int index = movieName.indexOf(userinput);
                // is the char exists in the movie name? and how many time it exist?
                if (index == -1)
                    userTries--;
                while(index>=0) {
                    nameChar[index] = userinput;
                    index = movieName.indexOf(userinput,index+1);
                }
                dashedMovieName=String.valueOf(nameChar);
                System.out.println(nameChar);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (userTries>0)
            System.out.println("Good job, you have win, Congratulations man!");
        else
            System.out.println("Sorry, you lose, GAME OVER, the movie name was: " + movieName);
    }
}

