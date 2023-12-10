public class InfiniteRecursion {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.printf("Chiamata n. %d %n", count++);
        main(args);
    }
}