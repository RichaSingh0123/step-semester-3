public class Main {
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || k < 1 || k > readings.length) {
            throw new IllegalArgumentException("Require 1 <= k <= readings.length.");
        }
        long sum = 0;
        for (int i = 0; i < k; i++) sum += readings[i];
        int count = sum >= (long) k * threshold ? 1 : 0;

        for (int right = k; right < readings.length; right++) {
            sum += readings[right];
            sum -= readings[right - k];
            if (sum >= (long) k * threshold) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4)); // 3
    }
}
