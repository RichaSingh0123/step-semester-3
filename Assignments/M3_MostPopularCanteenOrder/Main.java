import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // Returns {item, count}; ties are resolved by first appearance in orders.
    public static String[] mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) {
            throw new IllegalArgumentException("Orders must not be empty.");
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String item : orders) counts.put(item, counts.getOrDefault(item, 0) + 1);

        String bestItem = orders.get(0);
        int bestCount = counts.get(bestItem);
        for (String item : orders) {
            int count = counts.get(item);
            if (count > bestCount) {
                bestItem = item;
                bestCount = count;
            }
        }
        return new String[]{bestItem, Integer.toString(bestCount)};
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(
            mostPopular(List.of("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"))));
        System.out.println(java.util.Arrays.toString(
            mostPopular(List.of("tea", "coffee", "coffee", "tea"))));
    }
}
