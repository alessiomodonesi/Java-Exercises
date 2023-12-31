/**
 * T(n) = O(n)
 */
public interface Set extends Container {
    void add(Object obj);

    boolean contains(Object obj);

    Object[] toArray();
}