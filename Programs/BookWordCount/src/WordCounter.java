import java.util.Scanner;
import java.io.File;

public class WordCounter {
    public static void main(String[] args) throws Exception {
        File bookFile = new File("bookTextFile.txt");
        Scanner book = new Scanner(bookFile);
        int wordCount = 0;
        while (book.hasNextLine()) {
            String line = book.nextLine();
            wordCount += line.split(" ").length;
        }
        System.out.printf("This book contains %d words in it!", wordCount);
    }
}
