import java.util.Scanner;

public class Es7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a?: ");
        double a = input.nextDouble();
        System.out.print("b?: ");
        double b = input.nextDouble();
        input.close();

        double c = Math.hypot(a, b);
        double perimeter = a + b + c;
        double area = (a * b) / 2;
        double alpha = Math.toDegrees(Math.asin(a / c));
        double beta = Math.toDegrees(Math.acos(a / c));

        System.out.println("Ipotenusa: %.2f cm \nPerimetro: %.2f cm \nArea: %.2f cm2 \nAlpha: %.2f° \nBeta: %.2f°"
                .formatted(c, perimeter, area, alpha, beta));
    }
}