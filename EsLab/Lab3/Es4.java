import java.util.Scanner;

public class Es4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("string?: ");
        String string = input.nextLine();
        input.close();

        String[] numbers = string.split(" ");
        double results = 0;
        for (String a : numbers)
            results += Double.parseDouble(a);

        System.out.println(String.format("%s + %s + %s = %.2f", numbers[0], numbers[1], numbers[2], results));
    }
}
