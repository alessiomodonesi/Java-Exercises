import java.math.BigInteger;

public class BigNumbers {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("123456789");
        BigInteger b = new BigInteger("987654321");
        BigInteger c = a.multiply(b);
        System.out.println(c);
    }
}