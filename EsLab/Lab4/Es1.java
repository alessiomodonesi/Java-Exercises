import java.util.Arrays;
import java.util.Scanner;

public class Es1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] array = new String[3];

        System.out.print("s1?: ");
        array[0] = input.nextLine();
        System.out.print("s2?: ");
        array[1] = input.nextLine();
        System.out.print("s3?: ");
        array[2] = input.nextLine();
        input.close();

        Arrays.sort(array);
        System.out.println("Le stringhe in ordine lessicografico crescente sono:");
        for (String s : array)
            System.out.println(s);
    }
}
