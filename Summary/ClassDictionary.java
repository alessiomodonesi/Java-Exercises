@SuppressWarnings("rawtypes")
interface ClassDictionary extends Container {
    /**
     * se la chiave NON esiste la coppia viene aggiunta al dizionario
     * se esiste, il valore a essa associato viene sovrascritto dal nuovo valore
     * 
     * T(n) = O(n), O(n log n) con altro algoritmo
     * 
     * @exception IllegalArgumentException se key è null
     */
    void insert(Comparable key, Object value);

    /**
     * la rimozione della chiave rimuove anche il
     * corrispondente valore dal dizionario
     * 
     * T(n) = O(n), O(1) per chiavi non uniche
     * 
     * @exception DictionaryItemNotFoundException se la chiave non esiste
     */
    void remove(Comparable key);

    /**
     * T(n) = O(n), O(log n) per chiavi ordinate
     * 
     * @exception DictionaryItemNotFoundException se la chiave non esiste
     * @return valore associato alla chiave
     */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {
}