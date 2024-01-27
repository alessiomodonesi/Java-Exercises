/**
 * T(n) = O(n)
 */
public interface ClassSet extends Container {
    void add(Object obj);

    boolean contains(Object obj);

    Object[] toArray();
}