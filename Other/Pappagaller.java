import java.util.Scanner;

public class Pappagaller {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
            System.out.println(in.next());
        in.close();
        System.err.println("test error");
    }
}

// java Pappagaller.java < input.txt | sort > output.txt
// java Pappagaller.java < input.txt > output.txt 2> error.txt