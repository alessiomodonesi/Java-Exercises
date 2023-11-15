import java.util.Scanner;

public class Es3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("string?: ");
        String string = input.nextLine();
        input.close();

        String[] results = string.split(" ");
        for (int i = results.length - 1; i >= 0; i--)
            System.out.println(results[i]);
    }
}
