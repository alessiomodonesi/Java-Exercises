@SuppressWarnings({ "rawtypes", "unchecked" })
public class ArrayAlgs {
    public static int[] insert(int[] v, int vSize, int index, int value) {
        if (vSize == v.length)
            v = resize(v, 2 * v.length);
        for (int i = vSize; i > index; i--)
            v[i] = v[i - 1];
        v[index] = value;
        return v;
    }

    public static int findMin(int[] v, int vSize) {
        int min = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i] < min)
                min = v[i];
        return min;
    }

    public static int findMax(int[] v, int vSize) {
        int max = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i] > max)
                max = v[i];
        return max;
    }

    /**
     * Costruisce un array contenente valori casuali compresi tra 0 e n-1
     * 
     * @param lenght lunghezza dell'array
     * @param n      valore massimo -1
     * @return array di valori casuali
     */
    public static int[] randomIntArray(int length, int n) {
        int[] v = new int[length];
        for (int i = 0; i < v.length; i++)
            // ricordiamoci come funziona Math.random()...
            v[i] = (int) (n * Math.random());
        return v;
    }

    /**
     * Stampa tutti gli elementi di un array
     * 
     * @param v     array da stampare
     * @param vSize dimensione dell'array v
     * @return stringa contenente i valori dell'array
     */
    public static String printArray(int[] v, int vSize) {
        String s = "[";
        for (int i = 0; i < vSize; i++)
            s = s + v[i] + " ";
        s = s + "\b]";
        return s;
    }

    /**
     * Ridimensiona l'array oldv attribuendogli la lunghezza newLength
     * 
     * @param oldv      array su cui effettuare il resize
     * @param newLength nuova lunghezza dell'array
     * @return nuovo array di dimensione newlength
     */
    public static int[] resize(int[] oldv, int newLength) {
        if (newLength < 0 || oldv == null)
            throw new IllegalArgumentException();
        int[] newv = new int[newLength];
        int count = oldv.length;
        if (newLength < count)
            count = newLength;
        for (int i = 0; i < count; i++)
            newv[i] = oldv[i];
        return newv;
    }

    public static void remove(int[] v, int vSize, int index) {
        v[index] = v[vSize - 1];
    }

    public static void removeSorted(int[] v, int vSize, int index) {
        for (int i = index; i < vSize - 1; i++)
            v[i] = v[i + 1];
    }

    /**
     * Ordina un array con selezione
     * T(n) = O(n^2)
     * 
     * @param v     array da ordinare
     * @param vSize lunghezza dell'array
     */
    public static void selectionSort(Comparable[] v, int vSize) {
        for (int i = 0; i < vSize - 1; i++) {
            int minPos = findMinPos(v, i, vSize - 1);
            if (minPos != i)
                swap(v, minPos, i);
        }
    }

    private static void swap(Comparable[] v, int i, int j) {
        Comparable temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    private static int findMinPos(Comparable[] v, int from, int to) {
        int pos = from;
        Comparable min = v[from];
        for (int i = from + 1; i <= to; i++)
            if (v[i].compareTo(min) < 0) {
                pos = i;
                min = v[i];
            }
        return pos;
    }

    /**
     * Ordina un array con fusione
     * T(n) = O(n log n)
     * 
     * @param v     array da ordinare
     * @param vSize lunghezza dell'array
     */
    public static void mergeSort(Comparable[] v, int vSize) {
        if (vSize < 2)
            return; // caso base
        int mid = vSize / 2; // dividiamo circa a meta’
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[vSize - mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize - mid);
        mergeSort(left, mid); // passi ricorsivi
        mergeSort(right, vSize - mid);
        merge(v, left, right);
    }

    private static void merge(Comparable[] v, Comparable[] v1,
            Comparable[] v2) {
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length)
            if (v1[i1].compareTo(v2[i2]) < 0)
                v[i++] = v1[i1++];
            else
                v[i++] = v2[i2++];
        while (i1 < v1.length)
            v[i++] = v1[i1++];
        while (i2 < v2.length)
            v[i++] = v2[i2++];
    }

    /**
     * Ordina un array con inserimento
     * caso migliore T(n) = O(n)
     * caso peggiore T(n) = O(n^2)
     * 
     * @param v     array da ordinare
     * @param vSize lunghezza dell'array
     */
    public static void insertionSort(Comparable[] v, int vSize) {
        for (int i = 1; i < vSize; i++) {
            Comparable temp = v[i]; // elemento da inserire
            int j;
            for (j = i; j > 0 && temp.compareTo(v[j - 1]) < 0; j--)
                v[j] = v[j - 1];
            v[j] = temp;
        } // inserisci temp in posizione
    }

    /**
     * Ricerca sequenziale o lineare
     * T(n) = O(n)
     * 
     * @param v     array in cui cercare
     * @param vSize lunghezza dell'array
     * @param value valore da cercare
     */
    public static int linearSearch(int[] v, int vSize, int value) {
        for (int i = 0; i < vSize; i++)
            if (v[i] == value)
                return i; // trovato valore
        return -1; // valore non trovato
    }

    /**
     * Ricerca binaria
     * T(n) = O(log n)
     * 
     * @param v     array in cui cercare
     * @param vSize lunghezza dell'array
     * @param from  indice inizio ricerca
     * @param to    indice fine ricerca
     * @param value valore da cercare
     */
    public static int binarySearch(Comparable[] v, int vSize,
            Comparable value) {
        return binSearch(v, 0, vSize - 1, value);
    }

    private static int binSearch(Comparable[] v, int from, int to,
            Comparable value) {
        if (from > to)
            return -1; // caso base: el. non trovato
        int mid = (from + to) / 2; // circa in mezzo
        Comparable middle = v[mid];
        if (middle.compareTo(value) == 0)
            return mid; // trovato
        else if (middle.compareTo(value) < 0) // cerca a destra
            return binSearch(v, mid + 1, to, value);
        else // cerca a sinistra
            return binSearch(v, from, mid - 1, value);
    }

    /**
     * Genera un array bidimensionale con i
     * valori delle potenze di x^y.
     * 
     * @param x numero di righe
     * @param y numero di colonne
     * @return matrice
     */
    public static int[][] generatePowers(int x, int y) {
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
     * 
     * @param v     matrice
     * @param width numero di colonne
     */
    public static void printPowers(int[][] v, int width) {
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