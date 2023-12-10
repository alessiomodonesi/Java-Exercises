import java.util.Scanner;

public class SelectValue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] values = new double[10];

        for (int i = 0; i < values.length; i++)
            values[i] = in.nextDouble();

        System.out.println("Inserisci un numero:");
        int index = in.nextInt();
        in.close();

        if (index < 0 || index >= values.length)
            System.out.println("Valore errato");
        else
            System.out.println(values[index]);
    }
}