public class ArrayAlgs {
    public static int[] resize(int[] oldArray, int newLength) {
        if (newLength < 0 || oldArray == null)
            throw new IllegalArgumentException();
        int[] newArray = new int[newLength];
        int n = oldArray.length;
        if (newLength < n)
            n = newLength;
        for (int i = 0; i < n; i++)
            newArray[i] = oldArray[i];
        return newArray;
    }

    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++)
            // a[i] è un num intero casuale tra 0 e n-1 inclusi
            a[i] = (int) (n * Math.random());
        return a;
    }

    public static int[] insert(int[] v, int vSize, int index, int val) {
        if (vSize == v.length)
            v = resize(v, 2 * v.length);
        for (int i = vSize; i > index; i--)
            v[i] = v[i - 1];
        v[index] = val;
        return v;
    }

    public static int linearSearch(int[] v, int vSize, int value) {
        for (int i = 0; i < vSize; i++)
            if (v[i] == value)
                return i; // trovato valore
        return -1; // valore non trovato
    }

    public static int findMax(int[] v, int vSize) {
        int max = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i] > max)
                max = v[i];
        return max;
    }

    public static int findMin(int[] v, int vSize) {
        int min = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i] < min)
                min = v[i];
        return min;
    }

    public static void selectionSort(int[] v, int vSize) {
        for (int i = 0; i < vSize - 1; i++) {
            int minPos = findMinPos(v, i, vSize - 1);
            if (minPos != i)
                swap(v, minPos, i);
        }
    } // abbiamo usato due metodi ausiliari, swap e findMinPos

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

    public static void mergeSort(int[] v, int vSize) {
        if (vSize < 2)
            return; // caso base
        int mid = vSize / 2; // dividiamo circa a metà
        int[] left = new int[mid];
        int[] right = new int[vSize - mid];
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize - mid);
        // passi ricorsivi: ricorsione multipla (doppia)
        mergeSort(left, mid);
        mergeSort(right, vSize - mid);
        // fusione (metodo ausiliario)
        merge(v, left, right);
    }

    private static void merge(int[] v, int[] v1, int[] v2) {
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < v1.length && i2 < v2.length)
            if (v1[i1] < v2[i2])
                // prima si usa i, poi lo si incrementa...
                v[i++] = v1[i1++];
            else
                v[i++] = v2[i2++];
        while (i1 < v1.length)
            v[i++] = v1[i1++];
        while (i2 < v2.length)
            v[i++] = v2[i2++];
    }

    public static void insertionSort(int[] v, int vSize) {
        // il ciclo inizia da 1 perché il primo elemento non richiede attenzione
        for (int i = 1; i < vSize; i++) {
            int temp = v[i]; // nuovo el. da inserire
            // j va definita fuori dal ciclo perchè il
            // suo valore finale viene usato in seguito
            int j;
            // sposta di uno verso destra tutti gli el. a
            // sin. di temp e > di temp partendo da destra
            for (j = i; j > 0 && temp < v[j - 1]; j--)
                v[j] = v[j - 1];
            v[j] = temp; // inserisci temp
        }
    }

}