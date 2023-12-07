import java.awt.Rectangle;

public class MoveTester {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(5, 10, 20, 30);
        // sposta il rettangolo
        box.translate(15, 25);
        // visualizza informaz. su rettangolo traslato
        System.out.println("After moving, the top-left corner is:");
        System.out.println(box.getX());
        System.out.println(box.getY());
    }
}