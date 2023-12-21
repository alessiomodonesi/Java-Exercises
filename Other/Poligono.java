@SuppressWarnings("rawtypes")
public abstract class Poligono implements Comparable {
    public abstract double area();

    public int compareTo(Object obj) {
        Poligono p = (Poligono) obj;
        if (area() > p.area())
            return 1;
        if (area() < p.area())
            return -1;
        return 0;
    }
}