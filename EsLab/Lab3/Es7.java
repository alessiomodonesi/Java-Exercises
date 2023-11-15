import java.util.Scanner;

public class Es7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci il primo orario (formato 24 ore, es. 0900 o 1730): ");
        int primoOrario = input.nextInt();

        System.out.print("Inserisci il secondo orario (formato 24 ore, es. 0900 o 1730): ");
        int secondoOrario = input.nextInt();

        input.close();

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
