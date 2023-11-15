import java.util.Scanner;

public class Es6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("r?: ");
        double r = input.nextDouble();
        input.close();

        double cfr = 2 * Math.PI * r;
        double area = Math.PI * (r * r);

        System.out.println(String.format("r: %.2f, cfr = %.2f, A = %.2f", r, cfr, area));
    }
}