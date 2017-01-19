package _01_JavaAdvancedJavaSyntaxLab;

import java.util.Scanner;

public class _10_CalculateTriangleAreaMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        double area = base*height/2;
        System.out.printf("Area = %.2f",area);
    }
}
