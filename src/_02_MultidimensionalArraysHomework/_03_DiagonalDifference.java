package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _03_DiagonalDifference {

    public static int[] convertToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int dimensionOfMatix = Integer.parseInt(scanner.nextLine());
        int[][] matix = new int[dimensionOfMatix][dimensionOfMatix];
        for (int row = 0; row < dimensionOfMatix; row++) {
            String[] rowStr = scanner.nextLine().split(" ");
            matix[row]=convertToIntArray(rowStr);
        }
        int leftSum=0,rightSum=0;
        for (int row = 0; row < dimensionOfMatix; row++) {
            rightSum+=matix[row][row];
        }
        for (int row = dimensionOfMatix-1,col=0; row >=0 ; row--,col++) {
            leftSum+=matix[row][col];
        }
        System.out.println(Math.abs(leftSum-rightSum));
    }
}
