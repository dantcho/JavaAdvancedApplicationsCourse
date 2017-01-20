package _02_MultidimensionalArraysLab;

import java.util.Scanner;

public class _03_MaximumSumOf2x2Submatrix {

    public static int[] convertToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static int[][] readMatrix() {
        Scanner scanner = new Scanner(System.in);
        String[] strDimension = scanner.nextLine().split(", ");
        int[] dimension = convertToIntArray(strDimension);
        int[][] matrix = new int[dimension[0]][dimension[1]];
        for (int i = 0; i < dimension[0]; i++) {
            String[] strRow = scanner.nextLine().split(", ");
            matrix[i] = convertToIntArray(strRow);
        }
        return matrix;
    }

    public static void main(String[] args) {

        int bestSum = Integer.MIN_VALUE;
        int[][] matrix = readMatrix();
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        for (int row = resultRow; row < resultRow + 2; row++) {
            StringBuilder stringToPrint = new StringBuilder();
            for (int col = resultCol; col < resultCol + 2; col++) {
                stringToPrint.append(matrix[row][col] + " ");
            }
            System.out.println(stringToPrint.toString().trim());
        }

        System.out.println(bestSum);
    }
}
