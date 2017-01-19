package _02_MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_ReadSortAndPrintArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfItems = scanner.nextInt();
        scanner.nextLine();
        String[] names = new String[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            names[i]=scanner.nextLine();
        }
        Arrays.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
