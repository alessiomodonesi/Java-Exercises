public class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);// costruttore della superclasse
        transactionCount = 0; // azzera conteggio transaz.
    }

    public boolean deposit(double amount) // SOVRASCRITTO!!
    {
        super.deposit(amount); // aggiungi amount al saldo
        transactionCount++;
        return true;
    }

    public boolean withdraw(double amount) // SOVRASCRITTO!!
    {
        super.withdraw(amount); // sottrai amount dal saldo
        transactionCount++;
        return true;
    }

    public void deductFees() // NUOVO METODO
    {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fees = TRANSACTION_FEE *
                    (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }

    // nuovi campi di esemplare
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;
}