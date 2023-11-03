public class SimpleTriangle {
    private int a; // primo lato del triangolo
    private int b; // secondo lato del triangolo
    private int c; // terzo lato del triangolo

    public SimpleTriangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        int p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public int perimeter() {
        return a + b + c;
    }

    public java.lang.String toString() {
        return String.format("SimpleTriangle %d %d %d", a, b, c);
    }
}
