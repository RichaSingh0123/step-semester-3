import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static int[] readSeatNumbers(Scanner scanner) {
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();

        int[] seatNumbers = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter seat number " + (i + 1) + ": ");
            seatNumbers[i] = scanner.nextInt();
        }

        return seatNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] seatNumbers = readSeatNumbers(scanner);
        checkDuplicateSeats(seatNumbers);

        scanner.close();
    }
}
