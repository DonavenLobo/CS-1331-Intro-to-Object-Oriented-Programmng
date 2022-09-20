public class BankManager {
    public static void main(String[] args) {
        CheckingAccount myCheck = new CheckingAccount();
        SavingsAccount mySave = new SavingsAccount();
        COD myCOD = new COD();
        myCheck.accountNumber = 3347944;
        myCheck.balance = 100.21;
        System.out.println("1. " + myCheck.accountNumber);
        System.out.println("2. " + mySave.accountNumber);
        System.out.println("3. " + myCOD.accountNumber);

    }
}
