public class FixedArrayQueue implements Queue {
    public FixedArrayQueue() {
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
        if (back == v.length)
            throw new FullQueueException();
        v[back++] = obj;
    }

    public Object getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        return v[front];
    }

    public Object dequeue() {
        Object obj = getFront();
        front++; // attenzione all’effetto di questo incremento
        return obj;
    }

    // campi di esemplare e variabili statiche
    protected Object[] v;
    protected int front, back;
    public static final int INITSIZE = 100;
}