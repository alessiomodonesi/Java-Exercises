import java.util.Scanner;
import java.util.Locale;

public class TriangoloTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // lettura dei dati da Standard Input
        System.out.print("Introduci lati a, b, c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        in.close();

        // creazione di una istanza del triangolo
        Triangolo triangolo = new Triangolo(a, b, c);

        // emissione a Standard Output dell'elaborazione
        System.out.println(triangolo + ": " + triangolo.info());
        System.out.println("area = " + triangolo.area());
        System.out.println("h = " + triangolo.h());
    }
}