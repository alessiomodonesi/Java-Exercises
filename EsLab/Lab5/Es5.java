import java.util.Scanner;

public class Es5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "1";
        int n = 0, j = 2;

        do {
            System.out.print("Inserisci un numero positivo: ");
            n = input.nextInt();
        } while (!(n >= 0));
        input.close();

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
