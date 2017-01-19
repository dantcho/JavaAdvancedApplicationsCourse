package _01_JavaAdvancedJavaSyntaxHomework;

import java.util.Scanner;

public class _02_TriangleArea {

    public static void main(String[] args) {
        int aX, aY, bX, bY, cX, cY;
        Scanner scanner = new Scanner(System.in);
        aX = scanner.nextInt();
        aY = scanner.nextInt();
        bX = scanner.nextInt();
        bY = scanner.nextInt();
        cX = scanner.nextInt();
        cY = scanner.nextInt();
        System.out.println(Math.abs((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2));
    }
}
