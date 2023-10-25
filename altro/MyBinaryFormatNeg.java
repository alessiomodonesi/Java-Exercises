import java.util.Scanner;

public class MyBinaryFormatNeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci un numero negativo da -1 a -128");
        int numero = sc.nextInt();

        if (numero > 0)
            numero *= -1;

        sc.close();
        System.out.println(byteToInt((256 + numero), ""));
    }

    public static String byteToInt(int num, String num_b) {
        if (num_b.length() >= 9)
            return "0b" + num_b;
        else if (num_b.length() == 4)
            num_b = "_" + num_b;

        num_b = (num % 2) + num_b;
        num = num / 2;
        return byteToInt(num, num_b);
    }
}

/*
 * class Long_way{
 * public static void main(String[] args){
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("Inserisci un numero negativo da -1 a  -128");
 * int numero = sc.nextInt();
 * 
 * if(numero > 0)
 * numero *= -1;
 * 
 * sc.close();
 * numero += 256;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * num_b = "_" + num_b;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * num_b = (num % 2) + num_b;
 * num = num/2;
 * System.out.println(byteToInt("0b1" + num_b));
 * 
 * }
 * }
 */