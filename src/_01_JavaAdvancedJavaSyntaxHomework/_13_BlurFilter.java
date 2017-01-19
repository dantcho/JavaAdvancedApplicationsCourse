package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _13_BlurFilter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long blurAmount = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        long[][] lMatrix = new long[row][col];
        for (int i = 0; i < row; i++) {
            String[] rowsInputStr = scanner.nextLine().split(" ");
            long[] rowsInput = new long[rowsInputStr.length];
            for (int cols = 0; cols < rowsInputStr.length; cols++) {
                rowsInput[cols] = Long.parseLong(rowsInputStr[cols]);
            }
            for (int j = 0; j < col; j++) {
                lMatrix[i][j] = rowsInput[j];
            }
        }
        String[] targetStr = scanner.nextLine().split(" ");
        int[] target = new int[targetStr.length];
        for (int i = 0; i < targetStr.length; i++) {
            target[i] = Integer.parseInt(targetStr[i]);
        }
        ModfyMatrix(lMatrix, target[0], target[1], blurAmount);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(lMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void ModfyMatrix(long[][] lMatrix, int row, int col, long blurAmount) {
        int allRow = lMatrix.length;
        int allCol = lMatrix[row].length;
        int fromRow = row - 1;
        int toRow = row + 1;
        int fromCol = col - 1;
        int toCol = col + 1;
        if (fromRow < 0) {
            fromRow = 0;
        }
        if (fromCol < 0) {
            fromCol = 0;
        }
        if (toRow > allRow - 1) {
            toRow = allRow - 1;
        }
        if (toCol > allCol - 1) {
            toCol = allCol - 1;
        }
        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromCol; j <= toCol; j++) {
                lMatrix[i][j] = lMatrix[i][j] + blurAmount;
            }
        }
    }
}


