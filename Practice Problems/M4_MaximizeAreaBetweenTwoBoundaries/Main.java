public class Main {
    public static int maxContainerArea(int[] heights) {
        int left = 0, right = heights.length - 1, best = 0;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            best = Math.max(best, height * (right - left));
            if (heights[left] <= heights[right]) left++;
            else right--;
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxContainerArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }
}
