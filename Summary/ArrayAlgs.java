public class ArrayAlgs {
    /**
     * Ridimensiona l'array oldv attribuendogli la lunghezza newLength
     * 
     * @param oldv      array su cui effettuare il resize
     * @param newLength nuova lunghezza dell'array
     * @return nuovo array di dimensione newlength
     * @throws IllegalArgumentException
     */
    public static int[] resize(int[] oldv, int newLength) {
        if (newLength < oldv.length)
            throw new IllegalArgumentException();

        int[] newv = new int[newLength];
        System.arraycopy(oldv, 0, newv, 0, oldv.length);
        return newv;
    }

    /**
     * Ordina un array con selezione
     * T(n) = O(n^2)
     * 
     * @param v     array da ordinare
     * @param vSize lunghezza dell'array
     */
    public static void selectionSort(int[] v, int vSize) {
        for (int i = 0; i < vSize - 1; i++) {
            int minPos = findMinPos(v, i, vSize - 1);
            if (minPos != i)
                swap(v, minPos, i);
        }
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    private static int findMinPos(int[] v, int from, int to) {
        int pos = from;
        int min = v[from];
        for (int i = from + 1; i <= to; i++)
            if (v[i] < min) {
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
    public static void mergeSort(int[] v, int vSize) {
        if (vSize < 2)
            return; // caso base
        int mid = vSize / 2; // dividiamo circa a metà
        int[] left = new int[mid];
        int[] right = new int[vSize - mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize - mid);
        mergeSort(left, mid); // passi ricorsivi
        mergeSort(right, vSize - mid);
        merge(v, left, right);
    }

    private static void merge(int[] v, int[] v1,
            int[] v2) {
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length)
            if (v1[i1] < v2[i2])
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
    public static void insertionSort(int[] v, int vSize) {
        for (int i = 1; i < vSize; i++) {
            int temp = v[i]; // elemento da inserire
            int j;
            for (j = i; j > 0 && temp < v[j - 1]; j--)
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
    public static int binarySearch(int[] v, int vSize,
            int value) {
        return binSearch(v, 0, vSize - 1, value);
    }

    private static int binSearch(int[] v, int from, int to,
            int value) {
        if (from > to)
            return -1; // caso base: el. non trovato
        int mid = (from + to) / 2; // circa in mezzo
        int middle = v[mid];
        if (middle == value)
            return mid; // trovato
        else if (middle < value) // cerca a destra
            return binSearch(v, mid + 1, to, value);
        else // cerca a sinistra
            return binSearch(v, from, mid - 1, value);
    }
}