/**
 * Ogni operazione ha T(n) = O(1)
 */
public class FixedArrayStack implements Stack {
    public FixedArrayStack() {
        v = new Object[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return (vSize == 0);
    }

    public void push(Object obj) {
        if (vSize == v.length)
            throw new FullStackException();
        v[vSize++] = obj;
    }

    public Object top() {
        if (isEmpty())
            throw new EmptyStackException();
        return v[vSize - 1];
    }

    public Object pop() {
        Object obj = top();
        vSize--;
        return obj;
    }

    protected Object[] v;
    protected int vSize;
    public static final int INITSIZE = 100;
}