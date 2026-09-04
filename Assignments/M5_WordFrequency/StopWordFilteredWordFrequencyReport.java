import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFilteredWordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>();
        stopWords.add("the"); stopWords.add("was"); stopWords.add("and");
        stopWords.add("a"); stopWords.add("is"); stopWords.add("of"); stopWords.add("in");

        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\s+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequency.entrySet());
        entries.sort((first, second) -> Integer.compare(second.getValue(), first.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter feedback paragraph: ");
        String feedback = scanner.nextLine();
        printFilteredWordFrequency(feedback);
        scanner.close();
    }
}
