/**
 * Ogni operazione ha T(n) = O(1)
 */
public class ArrayStack implements Stack {
    protected Object[] v;
    protected int vSize;
    public static final int INITSIZE = 100;

    public ArrayStack() {
        v = new Object[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return (vSize == 0);
    }

    /**
     * Senza costante additiva (k * vSize), T(n) = O(1)
     * Con costante additiva (k + vSize), T(n) = O(n)
     */
    public void push(Object obj) {
        if (vSize == v.length)
            v = resize(2 * vSize);
        v[vSize++] = obj;
    }

    public Object pop() {
        Object obj = top();
        vSize--;
        return obj;
    }

    public Object top() {
        if (isEmpty())
            throw new EmptyStackException();
        return v[vSize - 1];
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }
}

interface Stack extends Container {
    void push(Object obj);

    Object pop();

    Object top();
}

class EmptyStackException extends RuntimeException {
}

class FullStackException extends RuntimeException {
}