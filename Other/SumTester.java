import java.util.Scanner;

public class SumTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        boolean done = false;
        while (!done) {
            String line;
            /*
             * attenzione a questa condizione: stiamo usando la
             * valutazione pigra e stiamo assegnando un nuovo
             * valore a line
             */
            if (!in.hasNextLine() ||
                    (line = in.nextLine()).equalsIgnoreCase("Q"))
                done = true;
            else
                sum = sum + Double.parseDouble(line);
        }
        in.close();
        System.out.println("Somma: " + sum);
    }
}