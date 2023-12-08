import java.util.Scanner;

public class TokenCounter {
    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);
        Scanner t = new Scanner(in.nextLine());
        in.close();

        while (t.hasNext()) {
            t.next(); // non devo elaborare
            count++;
        }

        t.close();
        System.out.println(count + " token");
    }
}