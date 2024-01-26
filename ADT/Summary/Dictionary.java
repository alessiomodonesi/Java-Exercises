/**
 * Dizionario con array ordinato
 * insert() ha prestazioni O(n)
 * remove() ha prestazioni O(n)
 * find() ha prestazioni O(log n)
 * 
 * Dizionario con array non ordinato
 * insert() ha prestazioni O(n)
 * O(1) per chiavi non uniche
 * remove() ha prestazioni O(n)
 * find() ha prestazioni O(n)
 */

@SuppressWarnings("rawtypes")
public interface Dictionary extends Container {
    // l'inserimento va sempre a buon fine; se la chiave non
    // esiste la coppia viene aggiunta al dizionario. Se esiste,
    // il valore a essa associato viene sovrascritto dal nuovo
    // valore; se key è null si lancia IllegalArgumentException
    void insert(Comparable key, Object value);

    // la rimozione della chiave rimuove anche il corrispondente
    // valore dal dizionario. Se la chiave non esiste si lancia
    // DictionaryItemNotFoundException
    void remove(Comparable key);

    // la ricerca per chiave restituisce (solo) il valore a essa
    // associato nel dizionario. Se la chiave non esiste si
    // lancia DictionaryItemNotFoundException
    Object find(Comparable key);
}

// Eccezione che segnala il mancato ritrovamento di una chiave
class DictionaryItemNotFoundException extends RuntimeException {
}