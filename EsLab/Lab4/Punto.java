public class Punto {
    private double ascissa;
    private double ordinata;

    public Punto(double ascissa, double ordinata) {
        this.ascissa = ascissa;
        this.ordinata = ordinata;
    }

    public double getAscissa() {
        return ascissa;
    }

    public double getOrdinata() {
        return ordinata;
    }

    public double distanza(Punto altroPunto) {
        double deltaX = ascissa - altroPunto.ascissa;
        double deltaY = ordinata - altroPunto.ordinata;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}