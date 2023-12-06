import java.util.Scanner;

public class ArrayAlgsTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = ArrayAlgs.randomIntArray(25, 100);

        System.out.printf("Elenco comandi: %n" +
                "Q -> Quit: termina il programma %n" +
                "P -> Print: stampa il contenuto dell'array %n" +
                "m -> min: calcola il minimo valore contenuto nell'array %n" +
                "M -> Max: calcola il massimo valore contenuto nell'array %n" +
                "r i -> remove index: rimuove dall'array l'elemento di indice i %n" +
                "R i -> Remove-sorted index: rimuove dall'array l'elemento di indice i, mantenendo l'ordine degli altri elementi %n"
                + "I i v -> Insert index value: inserisce il valore value nella posizione specificata dall'indice index %n");

        while (true) {
            System.out.printf("%nInserisci un comando: ");
            String input = in.next();

            switch (input) {
                case "Q":
                    in.close();
                    return;

                case "P":
                    System.out.println(ArrayAlgs.printArray(array, array.length));
                    break;

                case "m":
                    System.out.printf("Valore minimo dell'array: %d %n", ArrayAlgs.findMin(array, array.length));
                    break;

                case "M":
                    System.out.printf("Valore massimo dell'array: %d %n", ArrayAlgs.findMax(array, array.length));
                    break;

                case "r":
                    try {
                        System.out.print("Inserisci l'indice: ");
                        int i = Integer.parseInt(in.next());

                        ArrayAlgs.remove(array, array.length, i);
                        System.out.printf("Elemento %d rimosso", array[i]);
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                    break;

                case "R":
                    try {
                        System.out.print("Inserisci l'indice: ");
                        int j = Integer.parseInt(in.next());

                        ArrayAlgs.removeSorted(array, array.length, j);
                        System.out.printf("Elemento %d rimosso, mantenendo l'ordine degli altri elementi",
                                array[j]);
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                    break;

                case "I":
                    try {
                        System.out.print("Inserisci l'indice: ");
                        int x = Integer.parseInt(in.next());

                        System.out.print("Inserisci il valore: ");
                        int n = Integer.parseInt(in.next());

                        ArrayAlgs.insert(array, array.length, x, n);
                        System.out.printf("Elemento %d inserito in pos %d", n, x);
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                    break;

                default:
                    System.err.println("Invalid command!");
                    break;
            }
        }
    }
}
