public class main {
    public static void main(String[] args){
        // Creating a new contact manager object
        ContactsManager myContactManager = new ContactsManager();

        //Creating a new Contact object for myself
        Contact myself = new Contact();
        //Setting the fields of the object
        myself.name = "Donaven Lobo";
        myself.phoneNumber = "+1 (917) 34 7944";
        //Adding my own contact to the contacts manager by calling the addContact method
        myContactManager.addContact(myself);

        // Repeating the process for 4 more contacts
        Contact dad = new Contact();
        dad.name = "Julio Lobo";
        dad.phoneNumber = "+60 1137770777";
        myContactManager.addContact(dad);

        Contact mom = new Contact();
        mom.name = "Lorna Lobo";
        mom.phoneNumber = "+60 1132280777";
        myContactManager.addContact(mom);

        Contact bro = new Contact();
        bro.name = "Denver Lobo";
        bro.phoneNumber = "+1 (917) 886-0646";
        myContactManager.addContact(bro);

        Contact bff = new Contact();
        bff.name = "Athif Narangoli";
        bff.phoneNumber = "+60 11 2340 0322";
        myContactManager.addContact(bff);

        //Search for contact and print out their phone number
        Contact findPerson = myContactManager.searchContact("Denver Lobo");
        System.out.println(findPerson.phoneNumber);


    }
}
