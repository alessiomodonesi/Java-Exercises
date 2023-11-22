import java.util.Scanner;

public class Es2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("m e n?: ");
        int m = in.nextInt();
        int n = in.nextInt();
        in.close();

        int i = m;
        int j = n;
        if (m > n) {
            i = n;
            j = m;
        }

        int tmp;
        while ((tmp = i % j) != 0) {
            i = j;
            j = tmp;
        }

        System.out.println("MCD(" + m + "," + n + ") = " + j);
    }
}