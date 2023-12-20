@SuppressWarnings({ "rawtypes", "unused" })
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

    public void add(Comparable x) // prestazioni O(n)
    {
        return;
    } // Da completare: ordinamento per inserimento
      // É O(n), perche' inseriamo in un array ordinato

    public boolean contains(Object x) // prestaz. O(log n)
    {
        return true;
    } // da completare: usare ricerca binaria e compareTo

    public Comparable[] toSortedArray() // prestaz. O(n)
    {
        return null;
    } // da completare (v è già ordinato...)

    public Object[] toArray() // come sopra: l'array non deve essere per forza disordinato
    {
        return toSortedArray();
    }

    private Comparable[] resize(int newLength) // solito metodo
    {
        return null;
    } // da completare

    // campi di esemplare e variabili statiche
    private Comparable[] v;
    private int vSize;
    private static int INITSIZE = 100;
}