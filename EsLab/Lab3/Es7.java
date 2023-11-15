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

        System.out.println("Ipotenusa: %.2f cm\n".formatted(c) + //
                "Perimetro: %.2f cm\n".formatted(perimeter) + //
                "Area: %.2f cm2\n".formatted(area) + //
                "Alpha: %.2f°\n".formatted(alpha) + //
                "Beta: %.2f°".formatted(beta));
    }
}