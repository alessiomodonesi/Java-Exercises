import java.util.Scanner;

public class Es4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("s1?: ");
        String s1 = scanner.nextLine();

        System.out.print("s2?: ");
        String s2 = scanner.nextLine();

        scanner.close();

        if (checkSubsequence(s1, s2))
            System.out.println("s2 è sottosequenza di s1");
        else
            System.out.println("s2 NON è sottosequenza di s1");
    }

    private static boolean checkSubsequence(String s1, String s2) {
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j))
                j++;
            i++;
        }

        return j == s2.length();
    }
}
