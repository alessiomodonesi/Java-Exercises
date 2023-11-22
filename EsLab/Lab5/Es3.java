import java.util.Scanner;

public class Es3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max;

        do {
            System.out.print("Inserisci un numero positivo: ");
            max = input.nextInt();
        } while (max < 1);
        input.close();

        System.out.println("Numeri primi fino a " + max + ":");
        for (int i = 2; i <= max; i++) {
            if (isPrimo(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrimo(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
