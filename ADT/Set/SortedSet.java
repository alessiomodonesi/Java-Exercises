public interface SortedSet extends Set {
    void add(Comparable obj);

    Comparable[] toSortedArray();
}