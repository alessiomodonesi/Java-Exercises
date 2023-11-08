import java.util.Scanner;

public class Es5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res = "";
        int n = 0;

        do {
            System.out.print("n?: ");
            n = in.nextInt();
        } while (!(n >= 0 && n <= 99999));
        in.close();

        while (n > 0) {
            res += (n % 10 + " ");
            n /= 10;
        }

        for (int i = res.length() - 1; i >= 0; i--)
            System.out.print(res.charAt(i) + " ");
    }
}
