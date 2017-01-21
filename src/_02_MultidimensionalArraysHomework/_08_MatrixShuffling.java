package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("END")) {
            try {
                if (!input[0].equals("swap")) {
                    throw new Exception();
                }
                int cellARow = Integer.parseInt(input[1]);
                int cellACol = Integer.parseInt(input[2]);
                int cellBRow = Integer.parseInt(input[3]);
                int cellBCol = Integer.parseInt(input[4]);
                String cellA = matrix[cellARow][cellACol];
                String cellB = matrix[cellBRow][cellBCol];
                matrix[cellARow][cellACol] = cellB;
                matrix[cellBRow][cellBCol] = cellA;
                printMatrix(matrix);
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        int rows = matrix.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
