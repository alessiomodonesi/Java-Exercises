public class Triangolo {
    private double a;
    private double b;
    private double c;

    /*
     * Construttore della classe Triangolo
     */
    public Triangolo(double la, double lb, double lc) {
        this.a = la;
        this.b = lb;
        this.c = lc;
    }

    /*
     * restituisce informazioni sul triangolo. le informazioni sono relative
     * ai lati: equilatero, isoscele, scaleno.
     * agli angoli: acutangolo, rettangolo, ottusangolo.
     * Esempio: per il triangolo di lati 3, 4, 5 restituisce la stringa
     * "scaleno rettangolo".
     */
    public String info() {
        if (isTriangle(this.a, this.b, this.c)) {
            if (a == b && b == c) {
                return "equilatero";
            } else if (a == b || b == c) {
                if (this.angle(a, b, c) == 0)
                    return "isoscele ottusangolo";
                else if (angle(a, b, c) == 1)
                    return "isoscele rettangolo";
                else
                    return "isoscele acutangolo";
            } else {
                if (this.angle(a, b, c) == 0)
                    return "scaleno ottusangolo";
                else if (this.angle(a, b, c) == 1)
                    return "scaleno rettangolo";
                else
                    return "scaleno acutangolo";
            }
        } else
            return "non è un triangolo";
    }

    /*
     * restituisce una stringa contenente una descrizione testuale dell'oggetto
     * nel formato T(a, b, c)
     * Esempio "T(3, 4, 5)"
     */
    public String toString() {
        return "T(%.2f, %.2f, %.2f)".formatted(this.a, this.b, this.c);
    }

    /*
     * calcola e restituisce l'area del triangolo.
     * Usa la formula di Erone:
     * area * area = p * (p - a) * (p - b) * (p - c)
     * dove p e` il semiperimetro, ovvero p = (a + b + c) / 2
     */
    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /*
     * calcola e restituisce l'altezza del triangolo relativa al lato maggiore:
     */
    public double h() {
        return Math.sqrt((2 * area()) / max(this.a, this.b, this.c));
    }

    private boolean isTriangle(double a, double b, double c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    private int angle(double a, double b, double c) {
        if (c * c - a * a - b * b > 0)
            return 0;
        if (c * c - a * a - b * b == 0)
            return 1;
        if (c * c - a * a - b * b < 0)
            return 2;
        return -1;
    }

    private double max(double a, double b, double c) {
        if (a > b && b > c)
            return a;
        else if (a < b && b < c)
            return c;
        else
            return b;
    }
}