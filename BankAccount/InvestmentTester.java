class Investment {
    public Investment(double aBalance, double aRate) {
        balance = aBalance;
        rate = aRate;
        years = 0;
    }

    public void waitForBalance(double targetBalance) {
        while (balance < targetBalance) {
            years++;
            double interest = balance * rate / 100;
            balance = balance + interest;
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getYears() {
        return years;
    }

    private double balance;
    private double rate;
    private int years;
}

public class InvestmentTester {
    public static void main(String[] args) {
        final double INITIAL_BALANCE = 10000;
        final double RATE = 5;
        Investment invest = new Investment(INITIAL_BALANCE, RATE);
        invest.waitForBalance(2 * INITIAL_BALANCE);
        int years = invest.getYears();
        System.out.println("The investment doubled after " + years + " years");
    }
}