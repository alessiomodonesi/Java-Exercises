import java.util.Scanner;

public class Es3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("year?: ");
        int year = input.nextInt();
        input.close();

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            System.out.println(year + " è un anno bisestile");
        else
            System.out.println(year + " non è un anno bisestile");
    }
}
