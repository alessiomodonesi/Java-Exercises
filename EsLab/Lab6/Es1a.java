import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Es1a {
    public static void main(String[] args) {
        File inputFile = new File("input_double.txt");

        try {
            Scanner scanner = new Scanner(inputFile);
            int count = 0;
            double tot = 0;
            double squares = 0;

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                while (!isFloatingPointNumber(input))
                    input = scanner.nextLine();

                double value = Double.parseDouble(input);
                count++;
                tot += value;
                squares += value * value;
            }
            scanner.close();

            if (count > 1) {
                double average = tot / count;
                double deviation = Math.sqrt((squares - (tot * tot) / count) / (count - 1));
                System.out.println("Valore medio: " + average);
                System.out.println("Deviazione standard: " + deviation);
            } else if (count == 1)
                System.out.println("Hai inserito solo un valore. La deviazione standard è 0");
            else
                System.out.println("Nessun valore inserito. Il valore medio e la deviazione standard sono 0");

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }
    }

    private static boolean isFloatingPointNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
