package _10_ExamPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class NaturesProphet {
    final static String STOP = "Bloom Bloom Plow";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] token = input.split(" ");
        int width = Integer.valueOf(token[0]);
        int high = Integer.valueOf(token[1]);
        int[][] matrix = new int[width][high];
        input = reader.readLine();
        while (!input.equals(STOP)) {
            String[] tk = input.split(" ");
            int row = Integer.valueOf(tk[0]);
            int col = Integer.valueOf(tk[1]);
            bloom(matrix,row,col);
            input = reader.readLine();
        }
        printMatrix(matrix);

    }

    private static void bloom(int[][] matrix, int row, int col) {
        for (int c = 0; c < matrix[row].length; c++) {
            matrix[row][c]++;
        }
        for (int r = 0; r < matrix.length; r++) {
            matrix[r][col]++;
        }
        matrix[row][col]--;
    }
    public static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            StringJoiner j = new StringJoiner(" ");
            for (int i : matrix[row]) {
                j.add(""+i);
            }
            System.out.println(j.toString());
        }

    }
}
