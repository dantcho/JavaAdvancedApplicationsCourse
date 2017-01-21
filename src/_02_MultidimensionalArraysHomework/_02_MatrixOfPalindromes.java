package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrDimStr = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(arrDimStr[0]), cols = Integer.parseInt(arrDimStr[1]);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[][] matrixOfPalindromes = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrixOfPalindromes[row][col] = new String(new char[]{alphabet[row],alphabet[row+col],alphabet[row]});
            }
        }
        printMatrix(matrixOfPalindromes);
    }
    public static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            StringBuilder strToPrint = new StringBuilder();
            int rank = matrix[row].length;
            for (int col = 0; col < rank; col++) {
                strToPrint.append(matrix[row][col] + " ");
            }
            System.out.println(strToPrint.toString());
        }
    }
}
