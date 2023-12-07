import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumberer {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.nextLine();
        System.out.print("Output file: ");
        String outputFileName = console.nextLine();
        console.close();

        try {
            FileReader reader = new FileReader(inputFileName);
            Scanner in = new Scanner(reader);
            PrintWriter out = new PrintWriter(outputFileName);
            int lineNumber = 1;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                out.println("/* " + lineNumber + " */ " + line);
                lineNumber++;
            }
            in.close();
            out.close();
        } catch (IOException e) // gestione obbligatoria...
        {
            System.out.println("Error processing file:" + e);
        }
    }
}