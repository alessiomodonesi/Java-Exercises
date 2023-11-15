public class Es7 {
    public static void main(String[] args) {
        int primoOrario = 1000;
        int secondoOrario = 1200;
        int tempoTrascorso = 0;

        if (secondoOrario >= primoOrario)
            tempoTrascorso = secondoOrario - primoOrario;
        else
            tempoTrascorso = (2400 - primoOrario) + secondoOrario;

        int ore = tempoTrascorso / 100;
        int minuti = tempoTrascorso % 100;

        System.out.println("Tempo trascorso: " + ore + " ore e " + minuti + " minuti");
    }
}
