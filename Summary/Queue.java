/**
 * T(n) = O(1)
 */
public interface Queue extends Container {
    void enqueue(Object obj);

    Object dequeue();

    Object getFront();
}

class EmptyQueueException extends RuntimeException {
}

class FullQueueException extends RuntimeException {
}