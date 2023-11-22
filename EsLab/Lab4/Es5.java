import java.util.Scanner;

public class Es5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // richiede all'utente di inserire la data di compleanno in formato giorno mese
        System.out.print("Inserisci la data di compleanno (in formato giorno mese): ");
        String inputString = input.nextLine();
        input.close();

        // verifica se l'input corrisponde al formato prescritto
        String[] inputArray = inputString.split(" ");
        if (inputArray.length != 2) {
            System.out.println("L'input inserito non è una data");
            return;
        }

        int giorno;
        int mese;
        try {
            giorno = Integer.parseInt(inputArray[0]);
            mese = Integer.parseInt(inputArray[1]);
        } catch (NumberFormatException e) {
            System.out.println("L'input inserito non è una data");
            return;
        }

        // determina il segno zodiacale corrispondente alla data di compleanno
        String segno;
        if ((mese == 3 && giorno >= 21) || (mese == 4 && giorno <= 19)) {
            segno = "ARIETE";
        } else if ((mese == 4 && giorno >= 20) || (mese == 5 && giorno <= 20)) {
            segno = "TORO";
        } else if ((mese == 5 && giorno >= 21) || (mese == 6 && giorno <= 20)) {
            segno = "GEMELLI";
        } else if ((mese == 6 && giorno >= 21) || (mese == 7 && giorno <= 22)) {
            segno = "CANCRO";
        } else if ((mese == 7 && giorno >= 23) || (mese == 8 && giorno <= 22)) {
            segno = "LEONE";
        } else if ((mese == 8 && giorno >= 23) || (mese == 9 && giorno <= 22)) {
            segno = "VERGINE";
        } else if ((mese == 9 && giorno >= 23) || (mese == 10 && giorno <= 22)) {
            segno = "BILANCIA";
        } else if ((mese == 10 && giorno >= 23) || (mese == 11 && giorno <= 21)) {
            segno = "SCORPIONE";
        } else if ((mese == 11 && giorno >= 22) || (mese == 12 && giorno <= 21)) {
            segno = "SAGITTARIO";
        } else if ((mese == 12 && giorno >= 22) || (mese == 1 && giorno <= 19)) {
            segno = "CAPRICORNO";
        } else if ((mese == 1 && giorno >= 20) || (mese == 2 && giorno <= 18)) {
            segno = "ACQUARIO";
        } else if ((mese == 2 && giorno >= 19) || (mese == 3 && giorno <= 20)) {
            segno = "PESCI";
        } else {
            System.out.println("L'input inserito non è una data valida");
            return;
        }

        // visualizza l'oroscopo corrispondente al segno zodiacale
        switch (segno) {
            case "ARIETE":
                System.out.println("ARIETE");
                System.out.println("Amore: 3/5");
                System.out.println("Amicizia: 4/5");
                System.out.println("Lavoro: 4/5");
                break;
            case "TORO":
                System.out.println("TORO");
                System.out.println("Amore: 4/5");
                System.out.println("Amicizia: 3/5");
                System.out.println("Lavoro: 3/5");
                break;
            case "GEMELLI":
                System.out.println("GEMELLI");
                System.out.println("Amore: 2/5");
                System.out.println("Amicizia: 5/5");
                System.out.println("Lavoro: 5/5");
                break;
            case "CANCRO":
                System.out.println("CANCRO");
                System.out.println("Amore: 5/5");
                System.out.println("Amicizia: 2/5");
                System.out.println("Lavoro: 2/5");
                break;
            case "LEONE":
                System.out.println("LEONE");
                System.out.println("Amore: 4/5");
                System.out.println("Amicizia: 3/5");
                System.out.println("Lavoro: 3/5");
                break;
            case "VERGINE":
                System.out.println("VERGINE");
                System.out.println("Amore: 2/5");
                System.out.println("Amicizia: 4/5");
                System.out.println("Lavoro: 5/5");
                break;
            case "BILANCIA":
                System.out.println("BILANCIA");
                System.out.println("Amore: 4/5");
                System.out.println("Amicizia: 3/5");
                System.out.println("Lavoro: 3/5");
                break;
            case "SCORPIONE":
                System.out.println("SCORPIONE");
                System.out.println("Amore: 5/5");
                System.out.println("Amicizia: 2/5");
                System.out.println("Lavoro: 2/5");
                break;
            case "SAGITTARIO":
                System.out.println("SAGITTARIO");
                System.out.println("Amore: 3/5");
                System.out.println("Amicizia: 4/5");
                System.out.println("Lavoro: 4/5");
                break;
            case "CAPRICORNO":
                System.out.println("CAPRICORNO");
                System.out.println("Amore: 2/5");
                System.out.println("Amicizia: 4/5");
                System.out.println("Lavoro: 5/5");
                break;
            case "ACQUARIO":
                System.out.println("ACQUARIO");
                System.out.println("Amore: 3/5");
                System.out.println("Amicizia: 3/5");
                System.out.println("Lavoro: 4/5");
                break;
            case "PESCI":
                System.out.println("PESCI");
                System.out.println("Amore: 4/5");
                System.out.println("Amicizia: 2/5");
                System.out.println("Lavoro: 3/5");
                break;
        }
    }
}
