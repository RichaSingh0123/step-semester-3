import java.util.Scanner;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < words.length; index++) {
            StringBuilder reversedWord = new StringBuilder(words[index]);
            reversedWord.reverse();
            if (index > 0) {
                result.append(" ");
            }
            result.append(reversedWord);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();
        System.out.println(reverseEachWord(sentence));
        scanner.close();
    }
}
