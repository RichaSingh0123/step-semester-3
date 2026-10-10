import java.util.Arrays;

public class Main {
    // Returns {rowIndex, total}; ties remain with the smallest row index.
    public static int[] findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Marks must contain at least one student.");
        }
        int bestIndex = 0;
        int bestTotal = -1;
        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            for (int mark : marks[i]) {
                total += mark;
            }
            // Strict > preserves the earliest row when totals tie.
            if (total > bestTotal) {
                bestTotal = total;
                bestIndex = i;
            }
        }
        return new int[]{bestIndex, bestTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {{78, 85, 90}, {88, 92, 79}, {65, 70, 95}};
        System.out.println(Arrays.toString(findTopper(marks))); // [1, 259]
    }
}
