import java.util.Scanner;

public class PrimeNumberRecognizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        System.out.print("inserisci n: ");
        n = sc.nextInt();
        sc.close();

        for (int i = 2; i <= n / 2; i++) {
            if ((n % i) == 0) {
                System.out.println(String.format("il numero %d é divisibile per %d", n, i));
                System.exit(0);
            }
        }

        System.out.println(String.format("il numero %d é primo", n));
    }
}
