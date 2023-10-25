public class BankAccountTester {
    public static void main(String[] args) {
        BankAccount acct = new BankAccount(10000);
        final double RATE = 5;

        // calcola gli interessi dopo il primo anno
        double interest = acct.getBalance() * RATE / 100;

        // somma gli interessi dopo il primo anno
        acct.deposit(interest);
        System.out.println("Saldo dopo un anno: " + acct.getBalance() + " euro");

        // calcola gli interessi dopo il secondo anno
        interest = acct.getBalance() * RATE / 100;

        // somma gli interessi dopo il secondo anno
        acct.deposit(interest);

        System.out.println("Saldo dopo due anni: " + acct.getBalance() + " euro");
    }
}