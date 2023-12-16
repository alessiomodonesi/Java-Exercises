public class AccountTester1 {
    public static void main(String[] args) {
        SavingsAccount momsSavings = new SavingsAccount(0.5);
        CheckingAccount harrysChecking = new CheckingAccount(100);

        // metodi polimorfici di BankAccount e sue sottoclassi
        momsSavings.deposit(10000);// vengono invocati i metodi delle
        momsSavings.transfer(2000, harrysChecking); // sottoclassi
        harrysChecking.withdraw(1500);
        harrysChecking.withdraw(80);
        momsSavings.transfer(1000, harrysChecking);
        harrysChecking.withdraw(400);

        // simulazione della fine del mese
        momsSavings.addInterest(); // metodo solo di SavingsAccount
        harrysChecking.deductFees(); // metodo solo di CheckingAccount

        System.out.println("Mom’s savings balance = $"
                + momsSavings.getBalance());
        System.out.println("Harry’s checking balance = $"
                + harrysChecking.getBalance());
    }
}