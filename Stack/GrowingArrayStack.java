public class GrowingArrayStack extends FixedArrayStack {
    public void push(Object obj) {
        if (vSize == v.length)
            v = resize(2 * vSize);
        v[vSize++] = obj;
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }
}