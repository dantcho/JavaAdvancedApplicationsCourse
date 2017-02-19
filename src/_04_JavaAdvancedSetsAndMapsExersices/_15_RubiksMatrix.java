package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _15_RubiksMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] rubic = new int[dimension[0]][dimension[1]];
        int filler = 1;
        for (int row = 0; row < dimension[0]; row++) {
            for (int col = 0; col < dimension[1]; col++) {
                rubic[row][col] = filler;
                filler++;
            }
        }
        int nCommands = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line < nCommands; line++) {
            String[] commandArr = scanner.nextLine().split(" ");
            String command = commandArr[1];
            int rowOrCol = Integer.parseInt(commandArr[0]);
            int moveTimes = Integer.parseInt(commandArr[2]);
            if (command.equals("up") || command.equals("down")) {
                moveTimes = moveTimes % dimension[1];
                colShift(rubic, command, rowOrCol, moveTimes);

            } else {
                moveTimes = moveTimes % dimension[0];
                rowShift(rubic, command, rowOrCol, moveTimes);
            }
        }
        filler = 1;
        StringBuilder out = new StringBuilder();
        for (int row = 0; row < dimension[0]; row++) {
            for (int col = 0; col < dimension[1]; col++) {
                if (rubic[row][col] == filler) {
                    out.append("No swap required\n");
                } else {
                    int r = -1, c = -1;
                    for (int rows = 0; rows < dimension[0]; rows++) {
                        for (int cols = 0; cols < dimension[1]; cols++) {
                            if (rubic[rows][cols] == filler) {
                                r = rows;
                                c = cols;
                                break;
                            }
                        }
                    }
                    swap(rubic,row,col,r,c);
                    out.append("Swap (" + row + ", " + col + ") with (" + r + ", " + c + ")\n");
                }
                filler++;
            }
        }
        System.out.println(out);
    }

    private static void swap(int[][] rubic, int row, int col, int toRow, int toCol) {
        int temp = rubic[row][col];
        rubic[row][col]=rubic[toRow][toCol];
        rubic[toRow][toCol]=temp;
        return;
    }

    private static void rowShift(int[][] rubic, String command, int row, int moveTimes) {

        ArrayDeque<Integer> helpQuel = new ArrayDeque<>();
        if (command.equals("left")) {
            for (int col = 0; col < rubic[row].length; col++) {
                helpQuel.add(rubic[row][col]);
            }
            for (int i = 0; i < moveTimes; i++) {
                helpQuel.add(helpQuel.remove());
            }
            for (int col = 0; col < rubic[row].length; col++) {
                rubic[row][col] = helpQuel.remove();
            }

        } else {
            for (int col = 0; col < rubic[row].length; col++) {
                helpQuel.add(rubic[row][col]);
            }
            for (int i = 0; i < moveTimes; i++) {
                helpQuel.push(helpQuel.removeLast());
            }
            for (int col = 0; col < rubic[row].length; col++) {
                rubic[row][col] = helpQuel.remove();
            }
        }
    }

    private static void colShift(int[][] rubic, String command, int col, int moveTimes) {
        ArrayDeque<Integer> helpQuel = new ArrayDeque<>();
        if (command.equals("up")) {
            for (int row = 0; row < rubic.length; row++) {
                helpQuel.add(rubic[row][col]);
            }
            for (int i = 0; i < moveTimes; i++) {
                helpQuel.add(helpQuel.remove());
            }
            for (int row = 0; row < rubic.length; row++) {
                rubic[row][col] = helpQuel.remove();
            }

        } else {
            for (int row = 0; row < rubic.length; row++) {
                helpQuel.add(rubic[row][col]);
            }
            for (int i = 0; i < moveTimes; i++) {
                helpQuel.push(helpQuel.removeLast());
            }
            for (int row = 0; row < rubic.length; row++) {
                rubic[row][col] = helpQuel.remove();
            }
        }
    }
}
