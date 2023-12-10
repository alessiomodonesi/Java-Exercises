import java.util.Scanner;

/**
 * Programma che visualizza una tabella con i valori
 * delle potenze "x alla y", con x e y che variano
 * indipendentemente tra 1 ed un valore massimo
 * assegnato dall’utente.
 * I dati relativi a ciascun valore di x compaiono
 * su una riga, con y crescente da sinistra
 * a destra e x crescente dall’alto in basso.
 */
public class TableOfPowers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Calcolo dei valori di x alla y");
        System.out.println("Valore massimo di x:");
        int maxX = in.nextInt();
        System.out.println("Valore massimo di y:");
        int maxY = in.nextInt();
        int maxValue = (int) Math.round(Math.pow(maxX, maxY));
        int columnWidth = 1 + Integer.toString(maxValue).length();
        int[][] powers = generatePowers(maxX, maxY);
        printPowers(powers, columnWidth);
        in.close();
    }

    /**
     * Genera un array bidimensionale con i
     * valori delle potenze di x alla y.
     */
    private static int[][] generatePowers(int x,
            int y) {
        int[][] powers = new int[x][y];
        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                powers[i][j] = (int) Math.round(Math.pow(i + 1, j + 1));
        return powers;
    }

    /**
     * Visualizza un array bidimensionale di
     * numeri interi con colonne di larghezza
     * fissa e valori allineati a destra.
     */
    private static void printPowers(int[][] v,
            int width) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                String s = Integer.toString(v[i][j]);
                while (s.length() < width)
                    s = " " + s;
                System.out.print(s);
            }
            System.out.println();
        }
    }
}