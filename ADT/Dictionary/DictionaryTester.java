import java.util.Scanner;
import java.io.*;

/**
 * creazione dizionario: leggo dati da file e assumo che
 * il file abbia righe nel formato <numero int> <stringa>
 */
public class DictionaryTester {
    public static void main(String[] args) throws IOException {
        Scanner infile = new Scanner(new FileReader("file.txt"));
        Dictionary dict = new ArrayDictionary();
        // ... oppure = new SortedArrayDictionary();

        while (infile.hasNextLine()) {
            Scanner linescan = new Scanner(infile.nextLine());
            int key = Integer.parseInt(linescan.next());
            String value = linescan.next();
            dict.insert(key, value); // inserisco chiave e valore
        }
        infile.close();

        // ricerca/rimozione dati nel dizionario
        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.printf("%n**** Stampa Dizionario **** %n%s", dict);
            System.out.printf("%nF = find, R = remove, Q = quit %nScelta: ");
            String cmd = in.nextLine();

            if (cmd.equalsIgnoreCase("Q")) {
                done = true;
            } else if (cmd.equalsIgnoreCase("F")) {
                System.out.print("Chiave da trovare: ");
                int key = Integer.parseInt(in.nextLine());

                try {
                    // cerca key chiave e restituisce il valore
                    String value = (String) dict.find(key);
                    System.out.println("Valore: " + value);
                } catch (DictionaryItemNotFoundException e) {
                    System.out.println("Chiave non trovata");
                }
            } else if (cmd.equalsIgnoreCase("R")) {
                System.out.print("Chiave da rimuovere: ");
                int key = Integer.parseInt(in.nextLine());

                try {
                    // rimuove la coppia identificata da key
                    dict.remove(key);
                    System.out.println("Chiave rimossa");
                } catch (DictionaryItemNotFoundException e) {
                    System.out.println("Chiave non trovata");
                }
            }
        }
        in.close();
    }
}