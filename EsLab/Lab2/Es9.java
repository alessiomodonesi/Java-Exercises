import java.awt.Rectangle;

public class Es9 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 10, 50, 30);
        Rectangle r2 = new Rectangle(40, 20, 60, 40);

        System.out.println("Rettangolo 1:");
        System.out.println("Vertice in alto a sinistra: (" + r1.getX() + ", " + r1.getY() + ")");
        System.out.println("Altezza: " + r1.getHeight());
        System.out.println("Larghezza: " + r1.getWidth());

        System.out.println("Rettangolo 2:");
        System.out.println("Vertice in alto a sinistra: (" + r2.getX() + ", " + r2.getY() + ")");
        System.out.println("Altezza: " + r2.getHeight());
        System.out.println("Larghezza: " + r2.getWidth());

        Rectangle r3 = r1.intersection(r2);
        System.out.println("Intersezione tra i due rettangoli:");
        System.out.println("Vertice in alto a sinistra: (" + r3.getX() + ", " + r3.getY() + ")");
        System.out.println("Altezza: " + r3.getHeight());
        System.out.println("Larghezza: " + r3.getWidth());
    }
}
