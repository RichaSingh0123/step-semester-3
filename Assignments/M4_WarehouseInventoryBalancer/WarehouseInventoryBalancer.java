import java.util.Scanner;

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Both sections must have equal length.");
            return;
        }

        int totalA = calculateTotal(sectionA);
        int totalB = calculateTotal(sectionB);

        String status = totalA == totalB ? "Balanced" : "Not Balanced";

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.printf(
            "Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
            totalA, totalB, status, highestQuantity, highestSection, highestIndex + 1
        );
    }

    public static int calculateTotal(int[] quantities) {
        int total = 0;

        for (int quantity : quantities) {
            total += quantity;
        }

        return total;
    }

    public static int[] readInventory(Scanner scanner, String sectionName) {
        System.out.print("Enter number of items in " + sectionName + ": ");
        int count = scanner.nextInt();

        int[] quantities = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter quantity for item " + (i + 1) + ": ");
            quantities[i] = scanner.nextInt();
        }

        return quantities;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sectionA = readInventory(scanner, "Section A");
        int[] sectionB = readInventory(scanner, "Section B");

        analyzeInventory(sectionA, sectionB);

        scanner.close();
    }
}
