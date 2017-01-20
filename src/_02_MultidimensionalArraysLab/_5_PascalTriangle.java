package _02_MultidimensionalArraysLab;

import java.util.Scanner;

public class _5_PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt();
        long[][] pascalTr = new long[level][];
        for (int row = 0; row < pascalTr.length; row++) {
            pascalTr[row] = new long[row + 1];
            pascalTr[row][0] = 1;
            pascalTr[row][row] = 1;
            for (int i = 0; i < pascalTr[row].length; i++) {
                if (pascalTr[row][i] == 0) {
                    pascalTr[row][i] = pascalTr[row - 1][i - 1] + pascalTr[row - 1][i];
                }
            }
        }
        for (long[] elements : pascalTr) {
            StringBuilder strToPrint = new StringBuilder();
            for (long element : elements) {
                strToPrint.append(element + " ");
            }
            System.out.println(strToPrint.toString().trim());
        }
    }
}
