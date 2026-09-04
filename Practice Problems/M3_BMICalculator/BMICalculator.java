import java.util.Random;
import java.util.Scanner;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static double calculateBmi(double height, double weight) {
        return weight / (height * height);
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            System.out.println("Error: Height and weight arrays must have equal length.");
            return;
        }

        System.out.println("\nPerson | Height (m) | Weight (kg) | BMI | Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf(
                "%d | %.2f | %.2f | %.2f | %s%n",
                i + 1, heights[i], weights[i], bmi, status
            );
        }
    }

    public static double[] readValues(Scanner scanner, String valueName, int count) {
        double[] values = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter " + valueName + " for person " + (i + 1) + ": ");
            values[i] = scanner.nextDouble();
        }

        return values;
    }

    public static void generateRandomReport() {
        Random random = new Random();

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.35);
            weights[i] = 45 + (random.nextDouble() * 65);
        }

        printWellnessReport(heights, weights);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of people (or 0 for random 10-person demo): ");
        int count = scanner.nextInt();

        if (count == 0) {
            generateRandomReport();
        } else if (count > 0) {
            double[] heights = readValues(scanner, "height in meters", count);
            double[] weights = readValues(scanner, "weight in kg", count);
            printWellnessReport(heights, weights);
        } else {
            System.out.println("Number of people must be 0 or greater.");
        }

        scanner.close();
    }
}
