import java.util.Scanner;

public class Es1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0; // numero di valori
        double tot = 0; // somma dei valori
        double squares = 0; // somma dei valori al quadrato

        System.out.println("Inserisci i valori:");

        while (input.hasNextDouble()) {
            double value = input.nextDouble();
            count++;
            tot += value;
            squares += value * value;
        }
        input.close();

        if (count > 1) {
            double average = tot / count;
            double deviation = Math.sqrt((squares - (tot * tot) / count) / (count - 1));
            System.out.println("Valore medio: " + average);
            System.out.println("Deviazione standard: " + deviation);
        } else if (count == 1)
            System.out.println("Hai inserito solo un valore. La deviazione standard è 0");
        else
            System.out.println("Nessun valore inserito. Il valore medio e la deviazione standard sono 0");
    }
}
