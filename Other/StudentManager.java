import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] names = new String[10];
        double[] wMarks = new double[10];
        double[] oMarks = new double[10];
        int count = 0; // array riempiti solo in parte
        boolean done = false;

        while (!done) // inserimento dati studenti
        {
            String input = in.nextLine();
            if (input.length() == 0)
                done = true;
            else {
                Scanner t = new Scanner(input);
                if (count == names.length) // ridimensionamento array
                {
                    names = resizeString(names, count * 2);
                    wMarks = resizeDouble(wMarks, count * 2);
                    oMarks = resizeDouble(oMarks, count * 2);
                }
                names[count] = t.next();
                wMarks[count] = Double.parseDouble(t.next());
                oMarks[count] = Double.parseDouble(t.next());
                count++;
                t.close();
            }
        }

        done = false;
        while (!done) // visualizzazione dati inseriti
        {
            System.out.println("Comando? (Q per uscire, S per vedere)");
            String command = in.nextLine();
            if (command.equalsIgnoreCase("Q"))
                done = true;
            else if (command.equalsIgnoreCase("S")) {
                System.out.println("Cognome?");
                String name = in.nextLine();
                printAverage(names, wMarks, oMarks, name, count); // NOTA:
                // non abbiamo gestito l'eccezione lanciata da printAverage
            } else {
                System.out.println("Comando errato");
            }
        }
        in.close();
    }

    private static void printAverage(String[] names, double[] wMarks,
            double[] oMarks, String name, int count) {
        int i = findName(names, name, count);
        if (i == -1)
            throw new IllegalArgumentException();
        else {
            double avg = (wMarks[i] + oMarks[i]) / 2;
            System.out.println(name + " " + avg);
        }
    }

    private static int findName(String[] names, String name, int count) {
        for (int i = 0; i < count; i++)
            if (names[i].equals(name))
                return i;
        return -1;
    }

    private static String[] resizeString(String[] oldv, int newLength) {
        if (newLength < 0 || oldv == null)
            throw new IllegalArgumentException();
        String[] newv = new String[newLength];
        int count = oldv.length;
        if (newLength < count)
            count = newLength;
        for (int i = 0; i < count; i++)
            newv[i] = oldv[i];
        return newv;
    }

    private static double[] resizeDouble(double[] oldv, int newLength) {
        if (newLength < 0 || oldv == null)
            throw new IllegalArgumentException();
        double[] newv = new double[newLength];
        int count = oldv.length;
        if (newLength < count)
            count = newLength;
        for (int i = 0; i < count; i++)
            newv[i] = oldv[i];
        return newv;
    }
}