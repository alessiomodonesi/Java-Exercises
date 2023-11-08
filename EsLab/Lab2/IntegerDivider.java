import java.util.Scanner;

public class IntegerDivider {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("m?: ");
        int m = in.nextInt();

        System.out.print("n?: ");
        int n = in.nextInt();
        in.close();

        System.out.println("risultato: " + m / n);
    }
}
