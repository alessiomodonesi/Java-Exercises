import java.util.Scanner;

public class SortTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Dimensione dell'array? ");
        int n = in.nextInt();
        in.close();

        // costruisce un array casuale
        int[] a = ArrayAlgs.randomIntArray(n, 100);
        int aSize = a.length;

        // usa System.currentTimeMillis() per misurare il tempo
        long time = System.currentTimeMillis();

        // ArrayAlgs.selectionSort(a, aSize);
        // ArrayAlgs.mergeSort(a, aSize);
        // ArrayAlgs.insertionSort(a, aSize);

        time = System.currentTimeMillis() - time;
        System.out.println("Tempo trascorso: " + time + " ms");
    }
}