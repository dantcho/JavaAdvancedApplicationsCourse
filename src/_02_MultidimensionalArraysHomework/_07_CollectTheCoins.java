package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _07_CollectTheCoins {
    static String[][] board = new String[4][];
    static int hitCount = 0, coinsCollect = 0;
    static int[] currentPos = {0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int row = 0; row < 4; row++) {
            board[row] = scanner.nextLine().split("");
        }
        char[] commands = scanner.nextLine().toCharArray();
        for (int step = 0; step < commands.length; step++) {
            switch (commands[step]) {
                case '>':
                    moveRight();
                    break;
                case '<':
                    moveLeft();
                    break;
                case 'V':
                    moveDown();
                    break;
                case '^':
                    moveUp();
                    break;
            }
        }
        System.out.printf("Coins = %d\n", coinsCollect);
        System.out.printf("Walls = %d\n", hitCount);
    }

    private static void moveDown() {
        if (currentPos[0] + 1 == board.length || currentPos[1] >= board[currentPos[0]+1].length) {
            hitCount++;
        } else {
            currentPos[0]++;
            if (board[currentPos[0]][currentPos[1]].equals("$")) {
                coinsCollect++;
            }
        }
    }

    private static void moveUp() {
        if (currentPos[0] - 1 == -1 || currentPos[1] >= board[currentPos[0]-1].length) {
            hitCount++;
        } else {
            currentPos[0]--;
            if (board[currentPos[0]][currentPos[1]].equals("$")) {
                coinsCollect++;
            }
        }
    }

    private static void moveRight() {
        if (currentPos[1] + 1 == board[currentPos[0]].length) {
            hitCount++;
        } else {
            currentPos[1]++;
            if (board[currentPos[0]][currentPos[1]].equals("$")) {
                coinsCollect++;
            }
        }
    }

    private static void moveLeft() {
        if (currentPos[1] - 1 == -1) {
            hitCount++;
        } else {
            currentPos[1]--;
            if (board[currentPos[0]][currentPos[1]].equals("$")) {
                coinsCollect++;
            }
        }
    }

}
