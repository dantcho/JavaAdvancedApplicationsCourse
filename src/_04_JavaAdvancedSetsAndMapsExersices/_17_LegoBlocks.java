package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Arrays;
import java.util.Scanner;

public class _17_LegoBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        String[][] piece1 = new String[rows][];
        String[][] piece2 = new String[rows][];
        for (int row = 0; row < rows; row++) {
            piece1[row] = scanner.nextLine().trim().split("\\s+");
        }
        for (int row = 0; row < rows; row++) {
            piece2[row] = scanner.nextLine().trim().split("\\s+");
        }
        boolean isSqaure = true;
        int len = piece1[0].length + piece2[0].length;
        for (int row = 1; row < rows; row++) {
            if (piece1[row].length + piece2[row].length != len) {
                isSqaure = false;
                break;
            }
        }
        if (isSqaure) {
            String[][] outMatrix = new String[rows][len];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < piece1[row].length; col++) {
                    outMatrix[row][col] = piece1[row][col];
                }
                for (int col = piece1[row].length, colP2 = piece2[row].length - 1; col < len; col++, colP2--) {
                    outMatrix[row][col] = piece2[row][colP2];
                }
            }
            for (String[] row : outMatrix) {
                System.out.println(Arrays.asList(row));
            }
        } else {
            System.out.println("The total number of cells is: " + (countElements(piece1) + countElements(piece2)));
        }
    }

    private static int countElements(String[][] arr) {
        int elements = 0;
        for (int row = 0; row < arr.length; row++) {
            elements += arr[row].length;
        }
        return elements;
    }


}
