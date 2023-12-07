public class BankAccount {

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