import java.util.Scanner;
import java.io.*;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SimpleSetTester {
    public static void main(String[] args) throws IOException {
        // creazione degli insiemi:
        // leggo dati da file e assumo che il file contenga numeri interi, uno per riga
        Scanner fileA = new Scanner(new FileReader("A.txt"));
        Set setA = new ArraySet(); // SortedSet setA = new ArraySortedSet();
        while (fileA.hasNextLine())
            setA.add(Integer.parseInt(fileA.nextLine()));
        System.out.println("*** Insieme A ***");
        printSet(setA);
        fileA.close();

        Scanner fileB = new Scanner(new FileReader("B.txt"));
        Set setB = new ArraySet(); // SortedSet setB = new ArraySortedSet();
        while (fileB.hasNextLine())
            setB.add(Integer.parseInt(fileB.nextLine()));
        System.out.println("\n*** Insieme B ***");
        printSet(setB);
        fileB.close();

        // Collaudo metodi di unione, intersezione, differenza
        Set unione = union(setA, setB); // SortedSet unione = union(setA, setB);
        System.out.println("\n*** Insieme A U B ***");
        printSet(unione);

        Set intersezione = intersection(setA, setB);
        System.out.println("\n*** Insieme A ∩ B ***");
        printSet(intersezione);

        Set AsubB = subtract(setA, setB);
        System.out.println("\n*** Insieme A \\ B ***");
        printSet(AsubB);

        Set BsubA = subtract(setB, setA);
        System.out.println("\n*** Insieme B \\ A ***");
        printSet(BsubA);
    }

    /**
     * T(n) = O(n^2)
     */
    public static Set union(Set s1, Set s2) {
        Set x = new ArraySet();
        // inseriamo gli elementi del primo insieme
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        // inseriamo tutti gli elementi del
        // secondo insieme, sfruttando le
        // proprietà di add (niente duplicati...)
        v = s2.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        return x;
    }

    /**
     * Sorted T(n) = O(n log n)
     */
    public static SortedSet union(SortedSet s1, SortedSet s2) {
        SortedSet x = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) // merge
            if (v1[i].compareTo(v2[j]) < 0)
                x.add(v1[i++]);
            else if (v1[i].compareTo(v2[j]) > 0)
                x.add(v2[j++]);
            else // sono uguali
            {
                x.add(v1[i++]);
                j++;
            }
        while (i < v1.length)
            x.add(v1[i++]);
        while (j < v2.length)
            x.add(v2[j++]);
        return x;
    }

    /**
     * T(n) = O(n^2)
     * Sorted T(n) = O(n log n)
     */
    public static Set intersection(Set s1, Set s2) {
        Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (s2.contains(v[i]))
                x.add(v[i]);
        // inseriamo solo gli elementi che
        // appartengono anche al secondo
        // insieme, sfruttando le proprietà
        // di add (niente duplicati...)
        return x;
    }

    /**
     * T(n) = O(n^2)
     * Sorted T(n) = O(n log n)
     */
    public static Set subtract(Set s1, Set s2) {
        Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (!s2.contains(v[i]))
                x.add(v[i]);
        // inseriamo solo gli elementi che
        // *non* appartengono al secondo
        // insieme, sfruttando le proprietà
        // di add (niente duplicati...)
        return x;
    }

    public static void printSet(Set s) {
        Object[] array = s.toArray();
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}