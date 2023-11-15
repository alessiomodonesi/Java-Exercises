import java.util.Scanner;

public class Es10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("string?: ");
        String string = input.nextLine();
        input.close();

        String c = String.valueOf(string.charAt(0)).toUpperCase();
        string = c + string.substring(1, string.length());
        System.out.println(string);

        if ((string.substring(string.length() - 1, string.length())).equals("o") == true) {
            System.out.println(string.substring(0, string.length() - 1) + "ino");
            System.out.println(string.substring(0, string.length() - 1) + "issimo");
            System.exit(0);
        } else if ((string.substring(string.length() - 1, string.length())).equals("a") == true) {
            System.out.println(string.substring(0, string.length() - 1) + "ina");
            System.out.println(string.substring(0, string.length() - 1) + "issima");
            System.exit(0);
        } else
            System.exit(1);
    }
}
