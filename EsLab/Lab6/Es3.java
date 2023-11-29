import java.util.Scanner;

public class Es3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("s1?: ");
        String s1 = scanner.nextLine();
        if (s1.length() == 0) {
            scanner.close();
            return;
        }

        System.out.print("s2?: ");
        String s2 = scanner.nextLine();
        if (s2.length() == 0) {
            System.out.println("s2 è sottostringa di s1");
            scanner.close();
            return;
        }

        scanner.close();

        if (checkSubstring(s1, s2))
            System.out.println("s2 è sottostringa di s1");
        else
            System.out.println("s2 NON è sottostringa di s1");
    }

    private static boolean checkSubstring(String s1, String s2) {
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            boolean match = true;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match)
                return true;
        }
        return false;
    }
}
