import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Es2 {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("vispateresa.txt");
            Scanner in = new Scanner(reader);
            PrintWriter out = new PrintWriter("output.txt");

            while (in.hasNextLine()) {
                String[] words = in.nextLine().split(" ");

                for (int i = 0; i < words.length; i++) {
                    String firstLetter = words[i].substring(0, 1).toUpperCase();
                    String otherLetters = words[i].substring(1, words[i].length()).toLowerCase();
                    words[i] = firstLetter + otherLetters;

                    for (int j = 0; j < words[i].length(); j++) {
                        if (words[i].charAt(j) == '\'') // funziona, ma solo in questo caso specifico
                            words[i] = words[i].substring(0, 1) + '\'' + Character.toUpperCase(words[i].charAt(j + 1))
                                    + words[i].substring(3, words[i].length());
                    }
                }

                for (String s : words)
                    out.print(s + " ");
                out.print("\n");
            }
            reader.close();
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Error processing file:" + e);
        }
    }
}