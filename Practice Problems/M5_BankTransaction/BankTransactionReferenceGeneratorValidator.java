import java.util.Scanner;

public class BankTransactionReferenceGeneratorValidator {
    public static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() < 3) {
            return reference;
        }
        String bankCode = reference.substring(0, 3).toUpperCase();
        String remainingReference = reference.substring(3);
        return bankCode.concat(remainingReference);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequenceNumber = reference.substring(9);
        String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4)
                + "/" + date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] DATE: ")
              .append(formattedDate).append(" | SEQ: ").append(sequenceNumber);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String rawReference = scanner.nextLine();
        String normalizedReference = normalizeReference(rawReference);
        System.out.println(validateAndFormat(normalizedReference));
        scanner.close();
    }
}
