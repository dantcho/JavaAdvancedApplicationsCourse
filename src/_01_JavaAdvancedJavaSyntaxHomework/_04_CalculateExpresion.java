package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Locale;
import java.util.Scanner;

public class _04_CalculateExpresion {
    public static double average(double[] items) {
        int n = items.length, i;
        double sum = 0;
        for (i = 0; i < n; i++) {
            sum += items[i];
        }
        return sum / n;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner input = new Scanner(System.in);
        double a, b, c;
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        double f1 = Math.pow((a * a + b * b) / (a * a - b * b), ((a + b + c) / Math.sqrt(c)));
        System.out.printf("F1 result: %.2f; ",f1);
        double f2 = Math.pow(a * a + b * b - c * c * c, a - b);
        System.out.printf("F2 result: %.2f; ",f2);
        double av1 = average(new double[]{a, b, c});
        double av2 = average(new double[]{f1, f2});
        System.out.printf("Diff: %.2f",Math.abs(av1-av2));
    }
}
