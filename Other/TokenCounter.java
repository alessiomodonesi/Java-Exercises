import java.util.Scanner;

public class TokenCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner t = new Scanner(line);
            while (t.hasNext()) {
                t.next(); // non devo elaborare
                count++;
            }
            t.close();
        }
        in.close();
        System.out.println(count + " token");
    }
}