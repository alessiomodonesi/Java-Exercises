
/*
 * 
 * =============================================================================
 *
 * Esercizio - Trovare coppia di valori con somma X in un array int[]
 *
 * Realizzare il seguente metodo:
 *
 * public static int[] trovaCoppiaSommaX(int[] array)
 *
 * Il metodo deve verificare se esiste una coppia di valori (contigui oppure no)
 * la cui somma sia 42. Se esiste tale coppia (la prima trovata), questa deve essere
 * restituita in un array di esattamente 2 elementi (che costituiscono la coppia). Se non esiste, deve essere
 * restituito un array vuoto (ossia di lunghezza 0).
 
 * 
 * =============================================================================
 *  VALUTAZIONE
 *  compila e funziona -> 8 punti
 *  NON compila -> 0 punti 
 *  
 */
import java.util.Arrays;

public class CoppiaValoriSommaX {
    public static void main(String[] args) {
        System.out.println("Trovare coppia di valori con somma X in un array int[]");
        prova(new int[] { 5, -2, 9, -7 });
        prova(new int[] { 6, -4, 42, -3, 0 });
        prova(new int[] { -9, 48, -6, -8, 6, -6 });
    }

    private static void prova(int[] array) {
        String strArray = Arrays.toString(array);
        int[] risultato = trovaCoppiaSommaX(array);
        String strArrayRis = Arrays.toString(risultato);

        System.out.println(strArray + "  --->  " + strArrayRis);
    }

    public static int[] trovaCoppiaSommaX(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[i] + array[k] == 42)
                    return new int[] { array[i], array[k] };
            }
        }
        return new int[0];
    }
}
