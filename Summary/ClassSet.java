public class ClassSet implements Set {
    private Object[] v;
    private int vSize;
    private static int INITSIZE = 100;

    public ClassSet() {
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
                return true;
        return false;
    }

    // T(n) = O(n)
    public Object[] toArray() {
        Object[] x = new Object[vSize];
        System.arraycopy(v, 0, x, 0, vSize);
        return x;
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    /**
     * T(n) = O(n^2)
     * Sorted T(n) = O(n log n)
     */
    public static Set union(Set s1, Set s2) {
        Set x = new ClassSet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        v = s2.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        return x;
    }

    /**
     * T(n) = O(n^2)
     * Sorted T(n) = O(n log n)
     */
    public static Set intersection(Set s1, Set s2) {
        Set x = new ClassSet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (s2.contains(v[i]))
                x.add(v[i]);
        return x;
    }

    /**
     * T(n) = O(n^2)
     * Sorted T(n) = O(n log n)
     */
    public static Set subtract(Set s1, Set s2) {
        Set x = new ClassSet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (!s2.contains(v[i]))
                x.add(v[i]);
        return x;
    }

    public static void printSet(Set s) {
        Object[] array = s.toArray();
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

}

interface Set extends Container {
    void add(Object obj);

    boolean contains(Object obj);

    Object[] toArray();
}