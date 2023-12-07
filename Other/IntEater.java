import java.util.Scanner;

public class IntEater {
    public static void main(String[] args) {
        System.out.println("Passami un numero int!");
        Scanner in = new Scanner(System.in);
        int n = 0;
        boolean done = false;
        while (!done) {
            try {
                String line = in.nextLine();
                n = Integer.parseInt(line);
                // l'assegnazione seguente e` eseguita
                // solo se NON viene lanciata l'eccezione
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("No, voglio un int");
                // all'uscita del blocco catch done e` false
            }
        }
        in.close();
        System.out.println("Grazie, " + n + " e` un numero int!");
    }
}