package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _04_2x2SquaresInMatrix {

    public static int[] convertToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static char[] convertToCharArray(String[] strArray) {
        char[] charArray = new char[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            charArray[i] = strArray[i].charAt(0);
        }
        return charArray;
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int[] dimensionOfMatix = convertToIntArray(scanner.nextLine().split(" "));
        char[][] matix = new char[dimensionOfMatix[0]][dimensionOfMatix[1]];
        for (int row = 0; row < dimensionOfMatix[0]; row++) {
            String[] rowStr = scanner.nextLine().split(" ");
            matix[row] = convertToCharArray(rowStr);
        }
        int numberOfEqualSqare = 0;
        for (int row = 0; row < dimensionOfMatix[0] - 1; row++) {
            for (int col = 0; col < dimensionOfMatix[1] - 1; col++) {
                if (matix[row][col] == matix[row][col + 1] && matix[row][col] == matix[row + 1][col + 1] && matix[row][col] == matix[row + 1][col]) {
                    numberOfEqualSqare++;

                }

            }
        }
        System.out.println(numberOfEqualSqare);

    }
}