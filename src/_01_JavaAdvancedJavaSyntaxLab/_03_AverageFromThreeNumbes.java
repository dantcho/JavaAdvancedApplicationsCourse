package _01_JavaAdvancedJavaSyntaxLab;

import java.util.Scanner;

public class _03_AverageFromThreeNumbes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double third = scanner.nextDouble();
        double average = (first+second+third)/3;
        System.out.printf("%.2f",average);
    }
}
