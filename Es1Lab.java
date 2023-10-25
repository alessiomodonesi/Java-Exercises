import java.util.Scanner;

public class Es1Lab {
    public static void main(String[] args) {
        String tmp = "  ";
        Scanner input = new Scanner(System.in);
        
        System.out.print("Inserisci il tuo nome: ");
        String name = input.nextLine();
        input.close();

     	for (int i = 0; i < name.length(); i++)
     		tmp += "-";
        
        System.out.println(tmp);
        System.out.println("| " + name + " |");
        System.out.println(tmp);
    }
}
