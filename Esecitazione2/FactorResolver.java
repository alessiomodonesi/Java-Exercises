import java.util.Scanner;

public class FactorResolver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "1";
        int n = 0, j = 2;

        do {
            System.out.print("n?: ");
            n = in.nextInt();
        } while (!(n > 1));
        in.close();

        int k = n;

        while (j * j <= k) {
            while (k % j == 0) {
                s = s + " * " + j;
                k = k / j;
            }
            j++;
        }

        if (k > 1)
            s += " * " + k;

        System.out.println(n + " = " + s);
    }
}
