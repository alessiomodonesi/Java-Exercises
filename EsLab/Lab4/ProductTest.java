import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // creazione dei due prodotti
        System.out.println("Inserisci il nome del primo prodotto:");
        String name1 = input.nextLine();
        System.out.println("Inserisci il prezzo del primo prodotto:");
        double price1 = input.nextDouble();
        input.nextLine(); // consuma la nuova riga lasciata dal nextDouble()

        System.out.println("Inserisci il nome del secondo prodotto:");
        String name2 = input.nextLine();
        System.out.println("Inserisci il prezzo del secondo prodotto:");
        double price2 = input.nextDouble();

        Product product1 = new Product(name1, price1);
        Product product2 = new Product(name2, price2);

        // stampa dei due prodotti in ordine decrescente di prezzo
        System.out.println("Prodotti in ordine decrescente di prezzo:");
        if (product1.getPrice() >= product2.getPrice()) {
            System.out.println(product1.getName() + ": " + product1.getPrice());
            System.out.println(product2.getName() + ": " + product2.getPrice());
        } else {
            System.out.println(product2.getName() + ": " + product2.getPrice());
            System.out.println(product1.getName() + ": " + product1.getPrice());
        }

        // applicazione dello sconto al prodotto più caro
        System.out.println("Inserisci la percentuale di sconto da applicare al prodotto più caro:");
        double discountRate = input.nextDouble();
        input.close();
        if (product1.getPrice() >= product2.getPrice()) {
            product1.reducePrice(discountRate);
        } else {
            product2.reducePrice(discountRate);
        }

        // stampa dei due prodotti in ordine di prezzo
        System.out.println("Prodotti in ordine di prezzo:");
        System.out.println(product1.getName() + ": " + product1.getPrice());
        System.out.println(product2.getName() + ": " + product2.getPrice());
    }
}