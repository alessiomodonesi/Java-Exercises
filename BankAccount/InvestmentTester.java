class Investment {
    public Investment(double aBalance, double aRate) {
        balance = aBalance;
        rate = aRate;
        years = 0;
    }

    public void waitForBalance(double targetBalance) {
        while (balance < targetBalance) {
            years++;
            double interest = balance * rate / 100;
            balance = balance + interest;
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getYears() {
        return years;
    }

    private double balance;
    private double rate;
    private int years;
}

public class InvestmentTester {
    public static void main(String[] args) {
        final double INITIAL_BALANCE = 10000;
        final double RATE = 5;
        Investment invest = new Investment(INITIAL_BALANCE, RATE);
        invest.waitForBalance(2 * INITIAL_BALANCE);
        int years = invest.getYears();
        System.out.println("The investment doubled after " + years + " years");
    }
}

class SimpleInvestmentTester {
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