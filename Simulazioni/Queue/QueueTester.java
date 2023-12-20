import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class QueueTester {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) // controllo che da riga di comando sia
        { // stata passata esattamente una stringa
            System.out.println("uso: $java QueueTester outFile");
            System.exit(1);
        }

        // Inserimento elementi da file nella coda
        Scanner in = new Scanner(System.in);
        Queue coda = new ArrayQueue();
        while (in.hasNextLine()) {
            Scanner sc = new Scanner(in.nextLine());
            while (sc.hasNext()) {
                String token = sc.next();
                coda.enqueue(token);
            }
        }
        in.close();

        // Svuotamento della coda, e scrittura su file
        PrintWriter writer1 = new PrintWriter(args[0]);

        while (!coda.isEmpty())
            writer1.println((String) coda.dequeue());
        writer1.close();
    }
}

// --------------------------------------------------------------------------

class ArrayQueue implements Queue {
    public ArrayQueue() {
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

    // il metodo increment fa avanzare un indice di una
    // posizione, tornando all'inizio se si supera la fine.
    // Attenzione: non aggiorna direttamente i campi front,back
    protected int increment(int index) {
        return (index + 1) % v.length;
    }

    protected Object[] resize(int newLength) {
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    protected Object[] v;
    protected int front, back;
    protected static int INITSIZE = 5;
}
