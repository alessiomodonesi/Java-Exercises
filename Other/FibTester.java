public class FibTester {
    private static int invcount = 0; // variabile statica

    public static void main(String[] args) {
        int n = 0;
        if (args.length != 1) {
            System.out.println("Uso: $java FibTester <numero>");
            System.exit(1);
        }
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Inserire un intero!");
            System.exit(1);
        }
        System.out.println("*** Collaudo iterativeFib ***");
        for (int i = 1; i <= n; i++) {
            long f = iterativeFib(i);
            System.out.println("iterativeFib(" + i + ") = " + f);
        }
        System.out.println("\n*** Collaudo recursiveFib ***");
        for (int i = 1; i <= n; i++) {
            invcount = 0;
            long f = recursiveFib(i);
            System.out.println("recursiveFib(" + i + ") = " + f);
            System.out.println(invcount + " invocazioni");
        }
    }

    public static long recursiveFib(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        System.out.println("Inizio recursiveFib(" + n + ")");
        invcount++;
        long f;
        if (n < 3)
            f = 1;
        else
            f = recursiveFib(n - 1) + recursiveFib(n - 2);
        System.out.println("Uscita recursiveFib(" + n + ")");
        return f;
    }

    public static long iterativeFib(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        long f = 1;
        if (n >= 3) {
            long fib1 = 1;
            long fib2 = 1;
            for (int i = 3; i <= n; i++) {
                f = fib1 + fib2;
                fib2 = fib1;
                fib1 = f;
            }
        }
        return f;
    }
}