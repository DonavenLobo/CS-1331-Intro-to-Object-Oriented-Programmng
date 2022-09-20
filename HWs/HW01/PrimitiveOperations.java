//I worked on this homework assignment alone, using only course materials
public class PrimitiveOperations{
    public static void main(String[] args){
        /**
         * First, declare and initialize two variables, an integer type (byte, short, int, or long) anda floating point value (float or double). The names and values can be whatever youlike, for this step and all others. Make sure that the numbers you choose can be storedwithin the respective primitive type you choose. Print each of these values out on theirown line usingSystem.out.println().
         */
        int value1 = 10;
        double value2 = 5.75;
        System.out.println(value1);
        System.out.println(value2);
        /**
         * Multiply these variables together, and assign the outcome to anewvariable, ensuringthat no data is lost. For example, if I multiply 5 and 3.5, the answer should be 17.5.Print out this new value.
         */
        double mult = value1 * value2;
        System.out.println(mult);
        /**
         * Use casting to convert the integer from the first step to a floating point value and storethat in anothernewvariable. Print out the value.
         */
        float conv1 = (float)value1;
        System.out.println(conv1);
        /**
         * Use casting to convert the floating point value from the first step to an integer typeand store that in anewvariable. Print out the value.
         */
        int conv2 = (int)value2;
        System.out.println(conv2);
        /**
         * Shifting focus, declare acharvariable, and assign an uppercase letter to it. Print outthis value.
         */
        char letter = 'A';
        System.out.println(letter);
        /**
         * Using anumerical operation, change the letter to the same letter, but in lowercase. Usea numerical operation - do not reassign the variable. You may want to review a table ofASCII values as you’re working on this section. Print out the newcharvalue.Hint:1
         * you’ll likely have to use casting to get this to work.
         */
        int ASCIIVal = (int)letter;
        int DiffUpLow = (int)'a' - (int)'A';
        char lowerLetter = (char)(ASCIIVal + DiffUpLow);
        System.out.println(lowerLetter);
    }
}