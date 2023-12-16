public class SimpleBankAccount {
    public SimpleBankAccount() {
        balance = 0;
    }

    public SimpleBankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void transfer(double amount, SimpleBankAccount other) {
        withdraw(amount); // ovvero, this.withdraw(...)
        other.deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    private double balance;
}