import java.util.Scanner;

public class Es3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci la tua stringa: ");
        String string = input.nextLine();
        input.close();

        String[] results = string.split(" ");
        for (String a : results)
            System.out.println(a);
    }
}
