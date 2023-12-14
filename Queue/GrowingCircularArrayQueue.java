public class GrowingCircularArrayQueue
        extends FixedCircularArrayQueue {
    public void enqueue(Object obj) {
        if (increment(back) == front) // back e front distano 1
        {
            v = resize(2 * v.length);
            // se si ridimensiona v e la zona utile della coda è
            // attorno alla sua fine (cioè back < front) la seconda
            // metà del nuovo array rimane vuota e provoca un
            // malfunzionamento della coda, che si risolve spostando
            // la parte di coda che si trova all’inizio dell’array
            if (back < front) {
                System.arraycopy(v, 0, v, v.length / 2, back);
                back += v.length / 2;
            }
        }
        v[back] = obj;
        back = increment(back);
    }

    protected Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }
}