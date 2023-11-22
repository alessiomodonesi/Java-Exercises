import java.util.Scanner;

public class Es4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci una stringa: ");
        String str = input.nextLine();
        input.close();

        if (isPalindroma(str))
            System.out.println("La stringa è palindroma");
        else
            System.out.println("La stringa non è palindroma");
    }

    public static boolean isPalindroma(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }
}
