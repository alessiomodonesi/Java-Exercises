public class Pair {
    public interface Comparable {
        int compareTo(Object other);
    }

    public Pair(Comparable key, Object value) {
        setKey(key);
        setValue(value);
    }

    // metodi pubblici
    public String toString() {
        return key + " " + value;
    }

    public Comparable getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void setKey(Comparable key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    // campi di esemplare
    private Comparable key;
    private Object value;
}