public interface Deque extends Container {
    void addFirst(Object obj); // inserimento ai due capi

    void addLast(Object obj);

    Object removeFirst(); // rimozione ai due capi

    Object removeLast();

    Object getFirst(); // ispezione ai due capi

    Object getLast();

    int size(); // dimensione della deque
}

// solite eccezioni per contenitore pieno/vuoto
class EmptyDequeException extends RuntimeException {
}

class FullDequeException extends RuntimeException {
}