import java.util.Scanner;

public class DoubleDivider {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("m?: ");
        double m = in.nextDouble();

        System.out.print("n?: ");
        double n = in.nextDouble();
        in.close();

        System.out.println("risultato: " + m / n);
    }
}
