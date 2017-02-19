package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _19_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int filler = 1;
        List<List<Integer>> board = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            board.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                board.get(row).add(filler);
                filler++;
            }
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Nuke it from orbit")) break;
            String[] inArr = input.split("\\s+");
            int shotRow = Integer.parseInt(inArr[0]);
            int shotCol = Integer.parseInt(inArr[1]);
            int radius = Integer.parseInt(inArr[2]);
            shot(board, shotRow, shotCol, radius);
            shiftMatrix(board);
        }
        for (int row = 0; row < board.size(); row++) {
            StringBuilder out = new StringBuilder();
            for (int col = 0; col < board.get(row).size(); col++) {
                out.append(board.get(row).get(col)).append(" ");
            }
            System.out.println(out.toString().trim());
        }
    }

    private static void shiftMatrix(List<List<Integer>> board) {
        for (int row = 0; row < board.size(); row++) {
            int colLimit = board.get(row).size();
            for (int col = 0; col < colLimit; col++) {
                if (board.get(row).get(col) == 0) {
                    board.get(row).remove(col);
                    colLimit--;
                    if (board.get(row).size() == 0) {
                        board.remove(row);
                        row--;
                    }
                    col--;
                }
            }
        }
    }

    private static void shot(List<List<Integer>> board, int shotRow, int shotCol, int radius) {
        int startRow = shotRow - radius, endRow = shotRow + radius, startCol = shotCol - radius, endCol = shotCol + radius;
        if (startRow < 0) {
            startRow = 0;
        }
        if (endRow > board.size() - 1) {
            endRow = board.size() - 1;
        }
        if (startCol < 0) {
            startCol = 0;
        }

        for (int row = startRow; row <= endRow; row++) {


            if ((shotCol >= 0 && shotCol < board.get(row).size())) {
                board.get(row).set(shotCol, 0);
            }
            if (row == shotRow) {
                if (endCol > board.get(row).size() - 1) {
                    endCol = board.get(row).size() - 1;
                }
                for (int col = startCol; col <= endCol; col++) {
                    board.get(row).set(col, 0);
                }
            }
        }
    }
}


