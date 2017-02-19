package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Scanner;

public class _18_RadioactiveBunnies {
    public static boolean isWin = false;
    public static boolean isDie = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] board = new char[rows][cols];
        int[] position = new int[2];
        for (int row = 0; row < rows; row++) {
            board[row] = scanner.nextLine().toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'P') {
                    position[0] = row;
                    position[1] = col;
                    break;
                }
            }
        }
        char[] commands = scanner.nextLine().toCharArray();
        for (int turn = 0; turn < commands.length; turn++) {
            move(commands[turn], board, position);
            spreadBunny(board);
            if (isDie) {
                printBoard(board);
                System.out.println("dead: " + position[0] + " " + position[1]);
                return;
            }
            if (isWin) {
                printBoard(board);
                System.out.println("won: " + position[0] + " " + position[1]);
                return;
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.println(new String(board[row]));
        }
    }

    private static void spreadBunny(char[][] board) {
        char[][] tempArr = board.clone();
        for (int row = 0; row < board.length; row++) {
            tempArr[row] = board[row].clone();
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'B') {
                    for (int index = -1; index <= 1; index += 2) {
                        try {
                            if (board[row + index][col] == 'P') {
                                isDie = true;
                            }
                            tempArr[row + index][col] = 'B';
                        } catch (ArrayIndexOutOfBoundsException ex) {
                        }
                        try {
                            if (board[row][col + index] == 'P') {
                                isDie = true;
                            }
                            tempArr[row][col + index] = 'B';
                        } catch (ArrayIndexOutOfBoundsException ex) {
                        }
                    }
                }
            }
        }
        board = tempArr;
    }

    private static void move(char command, char[][] board, int[] position) {
        int iPos = 0;
        int dir = 0;
        switch (command) {
            case 'U':
                iPos = 0;
                dir = -1;
                break;
            case 'D':
                iPos = 0;
                dir = 1;
                break;
            case 'L':
                iPos = 1;
                dir = -1;
                break;
            case 'R':
                iPos = 1;
                dir = 1;
                break;
        }
        try {
            board[position[0]][position[1]] = '.';
            position[iPos] += dir;
            if (board[position[0]][position[1]] == 'B') {
                isDie = true;
                return;
            }
            board[position[0]][position[1]] = 'P';
        } catch (ArrayIndexOutOfBoundsException ex) {
            position[iPos] += dir * (-1);
            isWin = true;
        }
    }
}

