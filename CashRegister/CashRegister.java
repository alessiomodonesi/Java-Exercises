public class CashRegister {
    public CashRegister() {
        purchase = 0;
        payment = 0;
    }

    public void recordPurchase(double amount) {
        double newTotal = purchase + amount;
        purchase = newTotal;
    }

    public void enterPayment(int coinCount, Coin coinType) {
        double amount = coinCount * coinType.getValue();
        payment += amount;
    }

    public double giveChange() {
        double change = payment - purchase;
        payment = 0;
        purchase = 0;
        return change;
    }

    private double purchase;
    private double payment;
}