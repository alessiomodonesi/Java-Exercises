import java.util.Scanner;

public class RPNTester {
    public static void main(String[] args) {
        System.out.println("Inserisci operazione. Una stringa su una riga,");
        System.out.println("solo numeri e operatori +-*/ separati da spazi");
        Scanner in = new Scanner(System.in);
        String rpnString = in.nextLine();
        try {
            System.out.println("Risultato: " + evaluateRPN(rpnString));
        } catch (NumberFormatException e) {
            System.out.println("Uso di simboli non permessi!");
        } catch (EmptyStackException e) {
            System.out.println("Troppi operatori nell'espressione");
        } catch (IllegalStateException e) {
            System.out.println("Troppi numeri nell'espressione");
        } finally {
            in.close();
        }
    }

    private static double evaluateRPN(String rpnString)
            throws EmptyStackException, NumberFormatException, IllegalStateException {
        Stack st = new GrowingArrayStack();
        Scanner linescan = new Scanner(rpnString);
        while (linescan.hasNext()) {
            String s = linescan.next();
            if (isOperator(s)) // il token s è un operatore
            {
                Double r = evalOp(s, (Double) st.pop(), (Double) st.pop());
                st.push(r);
            } else // il token s non è un operatore
                st.push(Double.parseDouble(s)); // dovrebbe essere un numero
        }
        linescan.close();
        double result = (Double) st.pop();
        if (!st.isEmpty())
            throw new IllegalStateException();
        return result;
    }

    // verifica se il il token s è un operatore
    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    // calcola il risultato dell'operazione "left op right"
    private static double evalOp(String op, double right, double left) {
        if (op.equals("+"))
            return left + right;
        if (op.equals("-"))
            return left - right;
        if (op.equals("*"))
            return left * right;
        return left / right;
    }
}