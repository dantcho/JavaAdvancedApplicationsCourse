package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parameters = scanner.nextLine().split(", ");
        int size = Integer.parseInt(parameters[0]);
        int[][] matrix = new int[size][size];
        if (parameters[1].equals("A")) {
            generateMatrixA(matrix, size);
        } else {
            generateMatrixB(matrix, size);
        }
        printMatrix(matrix);
    }

    private static void generateMatrixA(int[][] matrix, int size) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    private static void generateMatrixB(int[][] matrix, int size) {
        int counter = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }else {
                for (int row = size-1; row >=0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }

            }
        }

    }

    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            StringBuilder strToPrint = new StringBuilder();
            for (int col = 0; col < matrix.length; col++) {
                strToPrint.append(matrix[row][col] + " ");
            }
            System.out.println(strToPrint.toString().trim());
        }

    }
}
