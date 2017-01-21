package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _06_SequenceInMatrix {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        int bestLen = 0;
        String[] bestSeq = {};
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int sumEqualVertical = findSumEqualsOnVertical(matrix, row, col);
                if (sumEqualVertical >= bestLen) {
                    bestLen = sumEqualVertical;
                    bestSeq = getEqualFromVertical(matrix, row, col, bestLen);
                }
                int sumOfEqualsOnDiagonal = findSumEqualOnDiagonal(matrix, row, col);
                if (sumOfEqualsOnDiagonal >= bestLen) {
                    bestLen = sumOfEqualsOnDiagonal;
                    bestSeq = getEqualsFromDiagonal(matrix, row, col, bestLen);
                }
                int sumOfEqualHorizontal = findSumEqualsOnHorizontal(matrix, row, col);
                if (sumOfEqualHorizontal >= bestLen) {
                    bestLen = sumOfEqualHorizontal;
                    bestSeq = getEqualFromHoriozntal(matrix, row, col, bestLen);
                }
            }
        }
        for (String s : bestSeq) {
            System.out.print(s + ", ");
        }
    }

    private static String[] getEqualsFromDiagonal(String[][] matrix, int row, int col, int len) {
        String[] equalElement = new String[len];
        for (int c = col, r = row, index = 0; index < len; c--, r--, index++) {
            equalElement[index] = matrix[r][c];
        }
        return equalElement;
    }

    private static int findSumEqualOnDiagonal(String[][] matrix, int row, int col) {
        int equalElement = 1;
        int colLimit = matrix[row].length - 1;
        int rowLimit = matrix.length - 1;
        for (int c = col, r = row; c >0 && r >0; c--, r--) {
            if (matrix[row][col].equals(matrix[r - 1][c - 1])) {
                equalElement++;
            } else break;
        }
        return equalElement;
    }

    private static String[] getEqualFromHoriozntal(String[][] matrix, int row, int col, int len) {
        String[] equalElement = new String[len];
        for (int r = row, index = 0; index < len; r--, index++) {
            equalElement[index] = matrix[r][col];
        }
        return equalElement;
    }

    private static int findSumEqualsOnHorizontal(String[][] matrix, int row, int col) {
        int equalElement = 1;
        int rowLimit = matrix.length - 1;
        for (int r = row; r > 0; r--) {
            if (matrix[row][col].equals(matrix[r - 1][col])) {
                equalElement++;
            } else break;
        }
        return equalElement;
    }

    private static String[] getEqualFromVertical(String[][] matrix, int row, int col, int len) {
        String[] equalElement = new String[len];
        for (int c = col, index = 0; index < len; c--, index++) {
            equalElement[index] = matrix[row][c];
        }
        return equalElement;
    }


    private static int findSumEqualsOnVertical(String[][] matrix, int row, int col) {
        int equalElement = 1;
        for (int c = col; c >0; c--) {
            if (matrix[row][col].equals(matrix[row][c - 1])) {
                equalElement++;
            } else break;
        }
        return equalElement;
    }
}
