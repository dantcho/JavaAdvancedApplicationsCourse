package _02_MultidimensionalArraysLab;

import java.util.Scanner;

public class _02_SumMatrixElements {
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
        int[][] matrix = readMatrix();
        int[] dimension = new int[2];
        dimension[0] = matrix.length;
        dimension[1] = matrix[0].length;
        int sum = 0;
        for (int row = 0; row < dimension[0]; row++) {
            for (int col = 0; col < dimension[1]; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(dimension[0]);
        System.out.println(dimension[1]);
        System.out.println(sum);

    }
}
