import java.util.Scanner;

public class Es6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = 0;

        do {
            System.out.print("n?: ");
            n = in.nextDouble();
        } while (!(n >= 0 && n < 32));
        in.close();

        String binaryString = String.format("%010d", Integer.parseInt(Integer.toBinaryString((int) n))) + ".";
        n -= (int) n;

        for (int i = 0; i < 5; i++) {
            n *= 2;
            binaryString += (int) n;
            n -= (int) n;
        }

        System.out.println(binaryString);
    }
}
