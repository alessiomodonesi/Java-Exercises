public class SimpleInvestmentTester {
    public static void main(String[] args) {
        final double INITIAL_BALANCE = 20000;
        final double RATE = 5;
        // definizione e inizializzazione
        BankAccount acct = new BankAccount(INITIAL_BALANCE);
        int year = 0; // anno
        while (acct.getBalance() < 2 * INITIAL_BALANCE) {
            year++; // incremento dell'anno
            double interest = acct.getBalance() * RATE / 100;
            acct.deposit(interest); // modifica saldo
        }
        System.out.println("L'investimento " +
                "raddoppia in " + year + " anni");
    }
}