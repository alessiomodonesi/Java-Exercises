class BankAccount implements Comparable<BankAccount> {
    protected double balance;
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

    public boolean equals(Object otherObject) {
        BankAccount otherAcct = (BankAccount) otherObject;
        return balance == otherAcct.balance;
    }

    public String toString() {
        return getClass().getName() +
                "[balance=" + balance + "]";
    }
}