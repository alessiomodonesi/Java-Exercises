import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Es1b {
    public static void main(String[] args) {
        String filename = "input_years.txt";

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                int year = -1;
                while (year != 0) {
                    try {
                        year = Integer.parseInt(scanner.nextLine());
                        if (year <= 0) {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
                        System.out.println(year + " è un anno bisestile");
                    else
                        System.out.println(year + " non è un anno bisestile");
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + filename);
            e.printStackTrace();
        }
    }
}