package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _05_MaximalSum {
    public static int[] convertToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensionOfMatix = convertToIntArray(scanner.nextLine().split(" "));
        int[][] matix = new int[dimensionOfMatix[0]][dimensionOfMatix[1]];
        for (int row = 0; row < dimensionOfMatix[0]; row++) {
            String[] rowStr = scanner.nextLine().split(" ");
            matix[row] = convertToIntArray(rowStr);
        }
        int bestSum = Integer.MIN_VALUE;
        int[] indexOfBestSum = {0, 0};
        for (int row = 0; row < dimensionOfMatix[0] - 2; row++) {
            for (int col = 0; col < dimensionOfMatix[1] - 2; col++) {
                int sum = findSum(matix, row, col);
                if (sum > bestSum) {
                    bestSum = sum;
                    indexOfBestSum[0] = row;
                    indexOfBestSum[1] = col;
                }
            }
        }
        System.out.println("Sum = " + bestSum);
        for (int row = indexOfBestSum[0]; row < indexOfBestSum[0] + 3; row++) {
            for (int col = indexOfBestSum[1]; col < indexOfBestSum[1] + 3; col++) {
                System.out.print(matix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int findSum(int[][] matix, int row, int col) {
        int sum = 0;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                sum += matix[r][c];
            }
        }
        return sum;
    }
}
