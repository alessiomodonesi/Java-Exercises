import java.util.Scanner;

public class Es4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a?: ");
        int a = input.nextInt();
        System.out.print("b?: ");
        int b = input.nextInt();
        System.out.print("c?: ");
        int c = input.nextInt();
        input.close();

        if (isTriangle(a, b, c)) {
            if (a == b && b == c) {
                System.out.println("triangolo equilatero");
            } else if (a == b || b == c) {
                if (angle(a, b, c) == 0)
                    System.out.println("triangolo isoscele ottusangolo");
                else if (angle(a, b, c) == 1)
                    System.out.println("triangolo isoscele rettangolo");
                else
                    System.out.println("triangolo isoscele acutangolo");
            } else {
                if (angle(a, b, c) == 0)
                    System.out.println("triangolo scaleno ottusangolo");
                else if (angle(a, b, c) == 1)
                    System.out.println("triangolo scaleno rettangolo");
                else
                    System.out.println("triangolo scaleno acutangolo");
            }
        } else
            System.out.println("non è un triangolo");
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    public static int angle(int a, int b, int c) {
        if (c * c - a * a - b * b > 0)
            return 0;
        if (c * c - a * a - b * b == 0)
            return 1;
        if (c * c - a * a - b * b < 0)
            return 2;
        return -1;
    }
}
