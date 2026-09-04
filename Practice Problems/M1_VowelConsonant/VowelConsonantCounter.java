import java.util.Scanner;

public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int index = 0; index < text.length(); index++) {
            char character = Character.toLowerCase(text.charAt(index));
            if (character == 'a' || character == 'e' || character == 'i'
                    || character == 'o' || character == 'u') {
                vowelCount++;
            } else if (character != ' ') {
                consonantCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        countVowelsAndConsonants(text);
        scanner.close();
    }
}
