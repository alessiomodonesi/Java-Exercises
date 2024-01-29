@SuppressWarnings("rawtypes")
interface Dictionary extends Container {
    /**
     * se la chiave NON esiste la coppia viene aggiunta al dizionario
     * se esiste, il valore a essa associato viene sovrascritto dal nuovo valore
     * 
     * Chiavi ordinate
     * T(n) = O(n) con insertion sort, O(n log n) con altro algoritmo
     * 
     * Chiavi NON ordinate
     * T(n) = O(n), O(1) per chiavi non uniche
     * 
     * @exception IllegalArgumentException se key è null
     */
    void insert(Comparable key, Object value);

    /**
     * la rimozione della chiave rimuove anche il
     * corrispondente valore dal dizionario
     * 
     * T(n) = O(n)
     * 
     * @exception DictionaryItemNotFoundException se la chiave non esiste
     */
    void remove(Comparable key);

    /**
     * Chiavi ordinate
     * T(n) = O(log n)
     * 
     * Chiavi NON ordinate
     * T(n) = O(n)
     * 
     * @exception DictionaryItemNotFoundException se la chiave non esiste
     * @return valore associato alla chiave
     */
    Object find(Comparable key);
}

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ClassDictionary implements Dictionary {
    protected Pair[] v;
    protected int vSize;
    protected final static int INITSIZE = 10;

    public ClassDictionary() {
        v = new Pair[INITSIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return vSize == 0;
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public void insert(Comparable key, Object value) {
        if (key == null)
            throw new IllegalArgumentException();

        try {
            remove(key);
        } catch (DictionaryItemNotFoundException e) {
        }

        if (vSize == v.length)
            v = resize(2 * vSize);

        v[vSize++] = new Pair(key, value);
    }

    public void remove(Comparable key) {
        v[linearSearch(key)] = v[--vSize];
    }

    public Object find(Comparable key) {
        return v[linearSearch(key)].getValue();
    }

    private int linearSearch(Comparable key) {
        for (int i = 0; i < vSize; i++)
            if (v[i].getKey().compareTo(key) == 0)
                return i;
        throw new DictionaryItemNotFoundException();
    }

    protected Pair[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Pair[] newv = new Pair[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < vSize; i++)
            s = s + v[i] + "\n";
        return s;
    }

    protected class Pair {
        private Comparable key;
        private Object value;

        public Pair(Comparable key, Object value) {
            setKey(key);
            setValue(value);
        }

        public Comparable getKey() {
            return key;
        }

        public void setKey(Comparable key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String toString() {
            return key + " " + value;
        }
    }
}

class DictionaryItemNotFoundException extends RuntimeException {
}