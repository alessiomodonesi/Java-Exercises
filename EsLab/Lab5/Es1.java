import java.util.Scanner;

public class Es1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        double sumOfSquares = 0;
        int count = 0;

        System.out.println("Inserisci i valori (termina con una sequenza non numerica):");

        while (input.hasNextDouble()) {
            double value = input.nextDouble();
            sum += value;
            sumOfSquares += value * value;
            count++;
        }

        if (count > 1) {
            double average = sum / count;
            double deviation = Math.sqrt((sumOfSquares - (sum * sum) / count) / (count - 1));
            System.out.println("Valore medio: " + average);
            System.out.println("Deviazione standard: " + deviation);
        } else if (count == 1) {
            System.out.println("Hai inserito solo un valore. La deviazione standard è 0.");
        } else {
            System.out.println("Nessun valore inserito. Il valore medio e la deviazione standard sono 0.");
        }
    }
}
