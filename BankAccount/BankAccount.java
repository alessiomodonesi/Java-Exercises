public class BankAccount {
    /**
     * Un conto bancario ha un saldo
     * modificabile tramite depositi e prelievi
     */
    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Preleva denaro dal conto
     * 
     * @param amount importo da prelevare
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    /**
     * Ispeziona saldo attuale
     * 
     * @return saldo attuale
     */
    public double getBalance() {
        return balance;
    }

    private double balance;
}