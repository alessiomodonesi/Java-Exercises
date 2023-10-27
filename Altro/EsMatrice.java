public class EsMatrice {
    public static void main(String[] args) {
        final int COLUMN_WIDTH = 5;
        for (int x = 1; x <= 4; x++) {
            for (int y = 1; y <= 5; y++) { // converte in stringa il valore
                String p = "" + (int) Math.round(Math.pow(x, y));
                // aggiunge gli spazi necessari
                while (p.length() < COLUMN_WIDTH)
                    p = " " + p;
                System.out.print(p);
            }
            System.out.println();
        }
    }
}
