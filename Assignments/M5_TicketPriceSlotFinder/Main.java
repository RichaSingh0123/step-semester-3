public class Main {
    // Returns the existing index or the insertion position (lower bound).
    public static int findSlot(int[] prices, int newPrice) {
        int low = 0, high = prices.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] < newPrice) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        System.out.println(findSlot(prices, 150)); // 1
        System.out.println(findSlot(prices, 210)); // 3
        System.out.println(findSlot(prices, 300)); // 4
    }
}
