import java.util.Scanner;

public class Es2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("n1?: ");
        double n1 = input.nextDouble();
        System.out.print("n2?: ");
        double n2 = input.nextDouble();
        input.close();

        if (Math.abs(n1 - n2) < 0.0001) {
            System.out.println("I due numeri sono approssimativamente uguali");
        } else {
            System.out.println("I due numeri non sono approssimativamente uguali");
        }
    }
}
