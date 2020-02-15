import java.util.Scanner;

public class QuantitiesUnits{

    public static void main(String[] args) {

        //read in inputs
        System.out.println("Provide program inputs: ");
        Scanner scanner = new Scanner(System.in);
        int unitCount = scanner.nextInt();
        System.out.println("Scanned int ");
        scanner.nextLine();
        String allUnits = scanner.nextLine();
        System.out.println("Scanned line ");
        String[] entries = new String[unitCount];
        for (int i = 0; i < entries.length; i++) {
            entries[i]=scanner.nextLine();
            System.out.println("Scanned line " + i);
        }
        scanner.close();
    }

    public String getOutput(){
        return "";
    }
}