package _01_JavaAdvancedJavaSyntaxHomework;

import java.util.Scanner;

public class _01_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();
        System.out.printf("%.2f", width * height);
    }
}
