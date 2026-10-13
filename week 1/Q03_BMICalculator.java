import java.util.Scanner;

public class Q03_BMICalculator {

    static String getBmiStatus(double bmi) {
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

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-15s %-15s %-12s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-15.2f %-15.2f %-12.2f %-15s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int TEAM_SIZE = 10;
        double[] heights = new double[TEAM_SIZE];
        double[] weights = new double[TEAM_SIZE];

        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Height in metres: ");
            heights[i] = sc.nextDouble();

            while (heights[i] <= 0) {
                System.out.print("Height must be positive. Enter again: ");
                heights[i] = sc.nextDouble();
            }

            System.out.print("Weight in kg: ");
            weights[i] = sc.nextDouble();

            while (weights[i] <= 0) {
                System.out.print("Weight must be positive. Enter again: ");
                weights[i] = sc.nextDouble();
            }
        }

        System.out.println("\n========== WELLNESS REPORT ==========");
        printWellnessReport(heights, weights);

        sc.close();
    }
}
