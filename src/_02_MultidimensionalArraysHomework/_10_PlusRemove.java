package _02_MultidimensionalArraysHomework;

import java.util.*;

public class _10_PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<int[]> resultList = new ArrayList<>();
        List<char[]> board = new ArrayList<>();
        while (!input.equals("END")) {
            board.add(input.toCharArray());
            input = scanner.nextLine();
        }

        int boardRows = board.size();
        for (int row = 0; row < boardRows; row++) {
            int rowCols = board.get(row).length;
            for (int col = 0; col < rowCols; col++) {
                char center = Character.toLowerCase(board.get(row)[col]);
                try {
                    char left = Character.toLowerCase(board.get(row)[col - 1]);
                    char right = Character.toLowerCase(board.get(row)[col + 1]);
                    char up = Character.toLowerCase(board.get(row - 1)[col]);
                    char down = Character.toLowerCase(board.get(row + 1)[col]);
                    if (center == left && center == right && center == up && center == down) {
                        int[] coordinate = {row, col};
                        resultList.add(coordinate);
                    }
                } catch (Exception c) {
                    continue;
                }
            }
        }
        for (int crossN = 0; crossN < resultList.size(); crossN++) {
            int rowCenter = resultList.get(crossN)[0];
            int colCenter = resultList.get(crossN)[1];
            board.get(rowCenter)[colCenter] = '\0';
            board.get(rowCenter - 1)[colCenter] = '\0';
            board.get(rowCenter + 1)[colCenter] = '\0';
            board.get(rowCenter)[colCenter - 1] = '\0';
            board.get(rowCenter)[colCenter + 1] = '\0';
        }
        for (char[] row : board) {
            for (char c : row) {
                if (c != '\0') {
                    System.out.print(c);
                }
            }
            System.out.println();
        }

    }

}
