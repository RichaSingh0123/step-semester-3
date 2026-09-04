import java.util.Scanner;

public class LibraryISBNNormalizerValidator {
    public static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3) {
            return code;
        }
        String publisherCode = code.substring(0, 3).toUpperCase();
        String remainingCode = code.substring(3);
        return publisherCode.concat(remainingCode);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int index = 3; index < code.length(); index++) {
            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: code body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7);

        StringBuilder result = new StringBuilder();
        result.append("[").append(publisherCode).append("] YEAR: ")
              .append(year).append(" | CATALOG: ").append(catalogNumber);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN-style code: ");
        String rawCode = scanner.nextLine();
        String normalizedCode = normalizeCode(rawCode);
        System.out.println(validateAndFormat(normalizedCode));
        scanner.close();
    }
}
