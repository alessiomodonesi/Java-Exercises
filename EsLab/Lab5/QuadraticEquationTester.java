import java.util.Scanner;

public class QuadraticEquationTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a?: ");
        double a = scanner.nextDouble();

        System.out.print("b?: ");
        double b = scanner.nextDouble();

        System.out.print("c?: ");
        double c = scanner.nextDouble();
        scanner.close();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        if (equation.hasSolutions()) {
            System.out.println("Le soluzioni reali dell'equazione sono:");
            System.out.println("x1 = %.2f".formatted(equation.getSolution1()));
            System.out.println("x2 = %.2f".formatted(equation.getSolution2()));
        } else
            System.out.println("L'equazione non ha soluzioni reali");
    }
}
