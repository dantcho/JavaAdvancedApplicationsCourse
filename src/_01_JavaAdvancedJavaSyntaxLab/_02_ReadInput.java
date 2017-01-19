package _01_JavaAdvancedJavaSyntaxLab;

import java.util.Scanner;

public class _02_ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();
        Integer firstInt = scanner.nextInt();
        Integer secondInt = scanner.nextInt();
        Integer thirdInt = scanner.nextInt();
        scanner.nextLine();
        String thirdString = scanner.nextLine();
        System.out.println(firstString + " " + secondString + " " + thirdString + " " + (firstInt + secondInt + thirdInt));
    }
}
