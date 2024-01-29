public class SlowFixedArrayQueue implements Queue {
    public SlowFixedArrayQueue() {
        v = new Object[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return (vSize == 0);
    }

    public void enqueue(Object obj) {
        if (vSize == v.length)
            throw new FullQueueException();
        v[vSize++] = obj;
    }

    public Object getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        return v[0];
    }

    /**
     * T(n) = O(n)
     */
    public Object dequeue() {
        Object obj = getFront();
        vSize--;
        for (int i = 0; i < vSize; i++)
            v[i] = v[i + 1];
        return obj;
    }

    // campi di esemplare e variabili statiche
    private Object[] v;
    private int vSize;
    public static final int INITSIZE = 100;
}