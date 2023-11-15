import java.util.Scanner;
import java.util.Locale;

public class Es5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // input.useLocale(Locale.US);
        input.useLocale(Locale.ITALY);

        System.out.print("a?: ");
        double a = input.nextDouble();
        System.out.print("b?: ");
        double b = input.nextDouble();
        System.out.print("c?: ");
        double c = input.nextDouble();
        input.close();

        System.out.println(String.format("%f + %f + %f = %f", a, b, c, a + b + c));
    }
}