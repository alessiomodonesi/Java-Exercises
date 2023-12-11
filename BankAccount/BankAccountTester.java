class BankAccount implements Comparable<BankAccount> {
    private double balance;
    private int accountNumber;
    private static int lastNumberAssigned = 100;

    public BankAccount() {
        balance = 0;
        lastNumberAssigned++;
        accountNumber = lastNumberAssigned;
    }

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        lastNumberAssigned++;
        accountNumber = lastNumberAssigned;
    }

    public int compareTo(BankAccount obj) {
        if (balance < obj.balance)
            return -1;
        if (balance > obj.balance)
            return 1;
        return 0;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

}

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