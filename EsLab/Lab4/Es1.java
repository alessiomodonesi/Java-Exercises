import java.util.Arrays;
import java.util.Scanner;

public class Es1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] arr = new String[3];

        System.out.print("s1?: ");
        arr[0] = input.nextLine();
        System.out.print("s2?: ");
        arr[1] = input.nextLine();
        System.out.print("s3?: ");
        arr[2] = input.nextLine();
        input.close();

        Arrays.sort(arr);
        System.out.println("Le stringhe in ordine lessicografico crescente sono:");
        for (String s : arr)
            System.out.println(s);
    }
}
