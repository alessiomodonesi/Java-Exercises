/**
 * Ogni operazione ha T(n) = O(1)
 */
interface Queue extends Container {
    void enqueue(Object obj);

    Object dequeue();

    Object getFront();
}

public class ClassQueue implements Queue {
    protected Object[] v;
    protected int front, back;
    public static final int INITSIZE = 100;

    public ClassQueue() {
        v = new Object[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty() {
        front = back = 0;
    }

    public boolean isEmpty() {
        return (back == front);
    }

    public void enqueue(Object obj) {
        if (increment(back) == front) {
            v = resize(2 * v.length);
            if (back < front) {
                System.arraycopy(v, 0, v, v.length / 2, back);
                back += v.length / 2;
            }
        }
        v[back] = obj;
        back = increment(back);
    }

    public Object dequeue() {
        Object obj = getFront();
        front = increment(front);
        return obj;
    }

    public Object getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        return v[front];
    }

    protected int increment(int index) {
        return (index + 1) % v.length;
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }
}

class EmptyQueueException extends RuntimeException {
}

class FullQueueException extends RuntimeException {
}