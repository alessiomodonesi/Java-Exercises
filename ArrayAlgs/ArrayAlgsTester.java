import java.util.Scanner;

public class ArrayAlgsTester {
    public static void main(String[] args) {
        int length = 0, max = 0;
        Scanner in = new Scanner(System.in);

        System.out.printf("Elenco comandi: %n" +
                "Q -> Quit: termina il programma %n" +
                "P -> Print: stampa il contenuto dell'array %n" +
                "m -> min: calcola il minimo valore contenuto nell'array %n" +
                "M -> Max: calcola il massimo valore contenuto nell'array %n" +
                "r i -> remove index: rimuove dall'array l'elemento di indice i %n" +
                "R i -> Remove-sorted index: rimuove dall'array l'elemento di indice i, mantenendo l'ordine degli altri elementi %n"
                + "I i v -> Insert index value: inserisce il valore value nella posizione specificata dall'indice index %n%n");

        try {
            System.out.printf("Length?: ");
            length = Integer.parseInt(in.next());
            System.out.printf("MaxValue?: ");
            max = Integer.parseInt(in.next());
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            in.close();
            return;
        }

        int[] array = ArrayAlgs.randomIntArray(length, max);

        while (true) {
            System.out.printf("%nInserisci un comando: ");
            String input = in.next();

            switch (input) {
                case "Q":
                    in.close();
                    return;

                case "P":
                    System.out.println(ArrayAlgs.printArray(array, length));
                    break;

                case "m":
                    System.out.printf("Valore minimo dell'array: %d %n", ArrayAlgs.findMin(array, length));
                    break;

                case "M":
                    System.out.printf("Valore massimo dell'array: %d %n", ArrayAlgs.findMax(array, length));
                    break;

                case "r":
                    try {
                        System.out.print("Inserisci l'indice: ");
                        int i = Integer.parseInt(in.next());

                        ArrayAlgs.remove(array, length, i);
                        length--;
                        array = ArrayAlgs.resize(array, length);
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                    break;

                case "R":
                    try {
                        System.out.print("Inserisci l'indice: ");
                        int j = Integer.parseInt(in.next());

                        ArrayAlgs.removeSorted(array, length, j);
                        length--;
                        array = ArrayAlgs.resize(array, length);
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println(e);
                    }
                    break;

                case "I":
                    try {
                        System.out.print("Inserisci l'indice: ");
                        int x = Integer.parseInt(in.next());

                        System.out.print("Inserisci il valore: ");
                        int value = Integer.parseInt(in.next());

                        array = ArrayAlgs.insert(array, length, x, value);
                        length++;
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
