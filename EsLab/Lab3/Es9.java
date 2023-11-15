import java.util.Scanner;

public class Es9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("string?: ");
        String string = input.nextLine();
        input.close();

        String[] words = string.split(" ");
        String translatedSentence = "P" + words[1] + " " + words[2] + " P" + words[3];

        System.out.println(translatedSentence.substring(0, 1).toUpperCase() + translatedSentence.substring(1));
    }
}
