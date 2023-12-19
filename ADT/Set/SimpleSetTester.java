import java.util.Scanner;
import java.io.*;

public class SimpleSetTester {
    public static void main(String[] args) throws IOException {
        // creazione degli insiemi:
        // leggo dati da file e assumo che il file contenga numeri interi, uno per riga
        Scanner file1 = new Scanner(new FileReader("ins1.txt"));
        Set insieme1 = new ArraySet();
        // SortedSet insieme1 = new ArraySortedSet();
        while (file1.hasNextLine())
            insieme1.add(Integer.parseInt(file1.nextLine()));

        System.out.println("\n\n*** Insieme 1 ***");
        printSet(insieme1);

        Scanner file2 = new Scanner(new FileReader("ins2.txt"));
        Set insieme2 = new ArraySet();
        // SortedSet insieme2 = new ArraySortedSet();
        while (file2.hasNextLine())
            insieme2.add(Integer.parseInt(file2.nextLine()));
        System.out.println("\n\n*** Insieme 2 ***");
        printSet(insieme2);

        file1.close();
        file2.close();

        // Collaudo metodi di unione, intersezione, differenza
        Set unione = union(insieme1, insieme2);
        // SortedSet unione = union(insieme1, insieme2);
        System.out.println("\n\n*** Insieme Unione ***");
        printSet(unione);

        Set intersezione = intersection(insieme1, insieme2);
        System.out.println("\n\n*** Insieme Intersezione ***");
        printSet(intersezione);

        Set differenza1 = subtract(insieme1, insieme2);
        System.out.println("\n\n*** Insieme diff (1 - 2) ***");
        printSet(differenza1);

        Set differenza2 = subtract(insieme2, insieme1);
        System.out.println("\n\n*** Insieme diff (2 - 1) ***");
        printSet(differenza2);
    }

    public static void printSet(Set s) {
        Object[] array = s.toArray(); // collaudo metodo toArray
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    // public static SortedSet union(SortedSet s1, SortedSet s2) {
    // SortedSet x = new ArraySortedSet();
    // Comparable[] v1 = s1.toSortedArray();
    // Comparable[] v2 = s2.toSortedArray();
    // int i = 0, j = 0;
    // while (i < v1.length && j < v2.length) // merge
    // if (v1[i].compareTo(v2[j]) < 0)
    // x.add(v1[i++]);
    // else if (v1[i].compareTo(v2[j]) > 0)
    // x.add(v2[j++]);
    // else // sono uguali
    // {
    // x.add(v1[i++]);
    // j++;
    // }
    // while (i < v1.length)
    // x.add(v1[i++]);
    // while (j < v2.length)
    // x.add(v2[j++]);
    // return x;
    // }

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
}