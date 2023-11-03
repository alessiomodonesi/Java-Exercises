import java.util.Scanner;

public class SimpleCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, max = 0, res = 0, i = 1;

        do {
            System.out.print("inserisci n > 0: ");
            n = sc.nextInt();
        } while (n <= 0);

        do {
            System.out.print("inserisci max > n: ");
            max = sc.nextInt();
        } while (max <= n);

        sc.close();
        System.out.println(String.format("multipli di %d in [%d, %d]", n, n, max));

        do {
            res = n * i++;
            if (res <= max)
                System.out.println(res);
        } while (res <= max);
    }
}
