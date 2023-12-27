@SuppressWarnings("rawtypes")
public class ArraySortedSet implements SortedSet {
    public ArraySortedSet() {
        v = new Comparable[INITSIZE];
        vSize = 0;
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return (vSize == 0);
    }

    public void add(Object x) // metodo di Set
    {
        throw new IllegalArgumentException();
    }

    public void add(Comparable x) // T(n) = O(n)
    {
        // Da completare: ordinamento per inserimento
        return;
    }

    public boolean contains(Object x) // T(n) = O(log n)
    {
        // da completare: usare ricerca binaria e compareTo
        return true;
    }

    public Comparable[] toSortedArray() // T(n) = O(n)
    {
        // da completare (v è già ordinato...)
        return null;
    }

    public Object[] toArray() // come sopra: l'array non deve essere per forza disordinato
    {
        return toSortedArray();
    }

    protected Comparable[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Comparable[] newv = new Comparable[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    // campi di esemplare e variabili statiche
    private Comparable[] v;
    private int vSize;
    private static int INITSIZE = 100;
}