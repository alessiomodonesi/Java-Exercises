public class SavingsAccount extends BankAccount {
    public SavingsAccount(double rate) {
        interestRate = rate;
    }

    public SavingsAccount(double initialBalance, double rate) {
        super(initialBalance);
        interestRate = rate;
    }

    public void addInterest() {
        deposit(getBalance() * interestRate / 100);
    }

    public boolean deposit(double amount) {
        super.deposit(amount); // invoca deposit della superclasse
        return withdraw(FEE);
    }

    private final static double FEE = 2.58; // euro
    private double interestRate;
}