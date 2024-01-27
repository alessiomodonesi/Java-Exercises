public class ArraySet implements Set {
    public ArraySet() {
        v = new Object[INITSIZE];
        vSize = 0;
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return (vSize == 0);
    }

    // T(n) = O(n) (usa contains)
    public void add(Object x) {
        if (contains(x))
            return;
        if (vSize == v.length)
            v = resize(2 * vSize);
        v[vSize++] = x;
    }

    // T(n) = O(n)
    public boolean contains(Object x) {
        for (int i = 0; i < vSize; i++)
            if (v[i].equals(x))
                return true; // non si può usare
        return false; // compareTo perchè x è solo un Object
    }

    // T(n) = O(n)
    public Object[] toArray() {
        Object[] x = new Object[vSize]; // creiamo un nuovo array
        System.arraycopy(v, 0, x, 0, vSize); // altrimenti si viola l’incapsulamento
        return x;
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    // campi di esemplare e var. statiche
    private Object[] v;
    private int vSize;
    private static int INITSIZE = 100;
}