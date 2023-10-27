import java.util.Scanner;

public class QEater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("Voglio una Q");
            String input = in.nextLine();
            if (input.equals("Q")) {
                System.out.println("Grazie!");
                done = true;
            } else
                System.out.println("Allora non hai capito...");
        }
        in.close();
    }
}