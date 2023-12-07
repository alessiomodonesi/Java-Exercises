import java.util.Scanner;
import java.util.Locale;

class Coin {
    public Coin(double value, String name) {
        this.value = value;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    private double value;
    private String name;
}

class CashRegister {
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

public class CashRegisterTester {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        Coin euro = new Coin(1, "eur");
        Coin euroCent = new Coin(0.01, "euCent");
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        boolean done = false;
        while (!done) {
            System.out.println("Prezzo articolo (Q per uscire):");
            String input = in.next();
            if (input.equalsIgnoreCase("Q"))
                done = true;
            else {
                double amount = Double.parseDouble(input);
                register.recordPurchase(amount);
            }
        }
        done = false;
        while (!done) {
            System.out.println("Inserire pagamento");
            System.out.println("Quantita' taglio (Q per uscire):");
            String input = in.next();
            if (input.equalsIgnoreCase("Q"))
                done = true;
            else {
                int coinCount = Integer.parseInt(input);
                String coinName = in.next();
                if (coinName.equals(euro.getName()))
                    register.enterPayment(coinCount, euro);
                else if (coinName.equals(euroCent.getName()))
                    register.enterPayment(coinCount, euroCent);
                else
                    System.out.println("Moneta sconosciuta");
            }
        }
        in.close();
        double change = register.giveChange();
        System.out.printf(Locale.US, "Resto dovuto: %.2f%n", change);
    }
}