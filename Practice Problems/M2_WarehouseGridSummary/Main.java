import java.util.Arrays;

public class Main {
    // Returns {totalItems, maxRow, maxCol}.
    public static long[] warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("Grid must be non-empty.");
        }
        long total = 0;
        int max = -1, maxRow = 0, maxCol = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int value = grid[r][c];
                total += value;
                if (value > max) {
                    max = value;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new long[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        System.out.println(Arrays.toString(warehouseSummary(grid))); // [49, 2, 1]
    }
}
