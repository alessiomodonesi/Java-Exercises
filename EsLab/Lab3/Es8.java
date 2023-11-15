import java.util.Scanner;

public class Es8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a?: ");
        double alpha = Math.toRadians(input.nextDouble());
        input.close();

        // Normalize the angle in the range (-2π, 2π)
        while (alpha <= -2 * Math.PI || alpha > 2 * Math.PI) {
            if (alpha <= -2 * Math.PI)
                alpha += 2 * Math.PI;
            else if (alpha > 2 * Math.PI)
                alpha -= 2 * Math.PI;
        }

        System.out.println("angolo = %.3f rad\n".formatted(alpha) + //
                "sin(alpha) = %.3f\n".formatted(Math.sin(alpha)) + //
                "cos(alpha) = %.3f\n".formatted(Math.cos(alpha)) + //
                "tan(alpha) = %.3f".formatted(Math.tan(alpha)));
    }
}