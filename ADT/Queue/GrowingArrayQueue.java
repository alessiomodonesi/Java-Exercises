
public class GrowingArrayQueue extends FixedArrayQueue {
    public void enqueue(Object obj) {
        if (back == v.length)
            v = resize(2 * v.length);
        v[back++] = obj;
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }
}