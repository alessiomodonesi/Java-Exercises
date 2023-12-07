import java.util.Scanner;

public class ReverseTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserire una stringa: ");
        String s = in.nextLine();
        in.close();

        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // aggiungi all’inizio
            r = ch + r;
        }

        System.out.println(s + " invertita è " + r);
    }
}