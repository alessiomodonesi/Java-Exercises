public class Recursion {
    public static int numeroTriangolare(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        if (n == 1)
            return 1; // caso base
        return n + numeroTriangolare(n - 1); // ricorsione
    }

    public static int numeroTriangolareSmart(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        return n * (n + 1) / 2;
    }

    public static int fattorialeRi(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        if (n == 0)
            return 1; // caso base
        return n * fattorialeRi(n - 1);
    }

    public static long[] fibGood(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        if (n < 2) {
            long[] res = { n, 0 };
            return res;
        }
        long[] temp = fibGood(n - 1); // ritorna [F(n-1), F(n-2)]
        long[] res = { temp[0] + temp[1], temp[0] }; // [F(n), F(n-1)]
        return res;
    }

    public static int pot(int n, int k) {
        if (k < 0)
            throw new IllegalArgumentException();
        if (k == 0)
            return 1;
        return n * pot(n, k - 1);
    }

    public static int square(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        else if (n == 0)
            return 0;
        else
            return (square(n - 1) + 2 * n - 1);
    }

    public static boolean isPrimo(int n) {
        if (n < 2)
            throw new IllegalArgumentException();
        return primoRi(n, 2);
    }

    public static boolean primoRi(int n, int k) {
        if (k * k > n)
            return true;
        if (n % k == 0)
            return false;
        return primoRi(n, k + 1);
    }

    public static String rev(String s) {
        if (s == null)
            return null;
        if (s.length() < 2)
            return s;
        return rev(s.substring(1)) + s.charAt(0);
    }

    public static boolean isPalindroma(String s) {
        if (s == null)
            throw new IllegalArgumentException();
        if (s.length() < 2)
            return true;
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        return isPalindroma(s.substring(1, s.length() - 1));
    }

    public static void printSubstring(String s) {
        if (s == null)
            throw new IllegalArgumentException();
        if (s.length() == 0)
            System.out.println(s);
        else {
            for (int i = 1; i <= s.length(); i++) {
                System.out.println(s.substring(0, i));
            }
            printSubstring(s.substring(1));
        }
    }

    // a è l’array da ordinare
    // n è il numero di componenti di a da ordinare
    public static void insertionSortRi(int[] a, int n) {
        if (n > 1)

        {
            insertionSortRi(a, n - 1);
            int value = a[n - 1];
            int i;
            for (i = n - 2; i >= 0 && a[i] > value; i--) {
                a[i + 1] = a[i];
            }
            a[i + 1] = value; // N.B. i è -1 usciti dal ciclo!
        }
    }

    public static void main(String[] args) {
        System.out.println("Soluzione Torre di Hanoi (n = " + args[0] + ")");
        solveHanoi(1, 3, 2, Integer.parseInt(args[0]));
    }

    public static void solveHanoi(int from, int to, int temp, int dim) {
        if (dim > 0) {
            solveHanoi(from, temp, to, dim - 1);
            System.out.println("Sposta il disco " + dim + " da T" + from + " a T" + to);
            solveHanoi(temp, to, from, dim - 1);
        }
    }
}