public class AccountTester2 {
    public static void main(String[] args) {
        SimpleBankAccount momsSavings = new SavingsAccount(0.5);
        SimpleBankAccount harrysChecking = new CheckingAccount(100);

        // metodi polimorfici di SimpleBankAccount e sue sottoclassi
        momsSavings.deposit(10000);// vengono invocati i metodi delle
        momsSavings.transfer(2000, harrysChecking); // sottoclassi
        harrysChecking.withdraw(1500); // anche se i riferimenti sono
        harrysChecking.withdraw(80); // di tipo SimpleBankAccount
        momsSavings.transfer(1000, harrysChecking);
        harrysChecking.withdraw(400);

        // simulazione della fine del mese
        ((SavingsAccount) momsSavings).addInterest(); // è necessario
        ((CheckingAccount) harrysChecking).deductFees(); // fare i cast

        System.out.println("Mom’s savings balance = $"
                + momsSavings.getBalance());
        System.out.println("Harry’s checking balance = $"
                + harrysChecking.getBalance());
    }
}