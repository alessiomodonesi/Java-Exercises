public class FixedCircularArrayQueue extends FixedArrayQueue {
    // il metodo increment fa avanzare un indice di una
    // posizione, tornando all’inizio se si supera la fine.
    // Attenzione: non aggiorna direttamente i campi front,back
    protected int increment(int index) {
        return (index + 1) % v.length;
    }

    public void enqueue(Object obj) // SOVRASCRITTO!
    {
        if (increment(back) == front)// condizione di coda piena
            throw new FullQueueException();
        v[back] = obj;
        back = increment(back);
    }

    public Object dequeue() // SOVRASCRITTO!
    {
        Object obj = getFront();
        front = increment(front);
        return obj;
    }
    // non serve sovrascrivere getFront perchè non modifica
    // le variabili back e front
}