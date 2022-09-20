public class StringOperations{
    public static void main(String[] args){
        /**
         * Create a newStringobject and assign it your name. Print it out.
         */
        String MyName = new String("Donaven Lobo");
        System.out.println(MyName);
        /**
         * Pick the first letter in your name, and replace it with ‘A’. Then, replace the last letterin your name with ‘Z’. Print out the result. Recall that, in Java, strings areimmutable,meaning you cannot change a String in-place. Do NOT just hard-code a new Stringwith the first and last letters changed.
         */
        String UpdatedName;
        UpdatedName = "A" + MyName.substring(1,MyName.length()-1) + "Z";
        System.out.println(UpdatedName);
        /**
         * Lastly, let’s work with some URLs.  Declare a newStringand give it the valueof some web address, in the formwww.name.tld, such aswww.gatech.eduorwww.stackoverflow.com. Print out this address.
         */
        String WebsiteName = new String("www.Glowganix.com");
        System.out.println(WebsiteName);

        String PureName = WebsiteName.substring(4,WebsiteName.length()-4);
        PureName = PureName + "1331";
        System.out.println(PureName);
    }
}