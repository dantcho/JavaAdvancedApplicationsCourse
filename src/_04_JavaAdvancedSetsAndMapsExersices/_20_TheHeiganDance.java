package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.*;

public class _20_TheHeiganDance {
    public static double heiganHealth = 3000000;
    public static int playerHealth = 18500;
    public static boolean isActivePlaque = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());
        boolean isWin = false;
        boolean isLoose = false;
        boolean isKilledFromPlaque = false;
        int[] playerPos = {7, 7};
        while (true) {
            heiganHealth -= damage;
            if (isActivePlaque) {
                playerHealth -= 3500;
                isActivePlaque = false;
            }
            if (playerHealth <= 0) {
                isLoose = true;
                isKilledFromPlaque = true;
            }
            if (heiganHealth <= 0) {
                isWin = true;
                break;
            }
            if (isLoose) {
                break;
            }


            String[] spellArr = scanner.nextLine().split(" ");
            String spell = spellArr[0];
            int hitRow = Integer.parseInt(spellArr[1]);
            int hitCol = Integer.parseInt(spellArr[2]);
            hitBoard(hitRow, hitCol, playerPos, spell);
            if (playerHealth <= 0) {
                if (spell.equals("Cloud")) isKilledFromPlaque = true;
                isLoose = true;
                break;
            }
        }
        if (isWin) {
            System.out.println("Heigan: Defeated!");
            if (isLoose) {
                System.out.println("Player: Killed by Plague Cloud");
            } else System.out.printf("Player: %d\n", playerHealth);
        } else {
            System.out.printf("Heigan: %.2f\n", heiganHealth);
            if (isKilledFromPlaque) {
                System.out.println("Player: Killed by Plague Cloud");
            } else {
                System.out.println("Player: Killed by Eruption");
            }
        }
        System.out.printf("Final position: %d, %d\n", playerPos[0], playerPos[1]);
    }

    private static void hitBoard(int hitRow, int hitCol, int[] playerPos, String spell) {
        boolean isHit = false;
        int[][] board = new int[15][15];

        int rowStart = hitRow - 1, rowEnd = hitRow + 1, colStart = hitCol - 1, colEnd = hitCol + 1;
        if (rowStart < 0) {
            rowStart = 0;
        }
        if (rowEnd > 14) {
            rowEnd = 14;
        }
        if (colStart < 0) {
            colStart = 0;
        }
        if (colEnd > 14) {
            colEnd = 14;
        }
        for (int row = rowStart; row <= rowEnd; row++) {
            for (int col = colStart; col <= colEnd; col++) {
                board[row][col] = 1;
            }
        }
        if (board[playerPos[0]][playerPos[1]] == 1) {
            if (playerPos[0] - 1 < 0 || board[playerPos[0] - 1][playerPos[1]] == 1) {
                if (playerPos[1] + 1 > 14 || board[playerPos[0]][playerPos[1] + 1] == 1) {
                    if (playerPos[0] + 1 > 14 || board[playerPos[0] + 1][playerPos[1]] == 1) {
                        if (playerPos[1] - 1 < 0 || board[playerPos[0]][playerPos[1] - 1] == 1) {
                            isHit = true;
                        } else playerPos[1]--;
                    } else playerPos[0]++;
                } else playerPos[1]++;
            } else playerPos[0]--;
        }
        if (isHit) {
            if (spell.equals("Cloud")) {
                isActivePlaque = true;
                playerHealth -= 3500;
            } else {
                playerHealth -= 6000;
            }
        }
    }
}
