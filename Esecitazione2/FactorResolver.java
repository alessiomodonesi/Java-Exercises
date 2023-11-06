import java.util.Scanner;

public class FactorResolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        do {
            System.out.print("inserisci n: ");
            n = sc.nextInt();
        } while (!(n > 1));
        sc.close();

    }
}
