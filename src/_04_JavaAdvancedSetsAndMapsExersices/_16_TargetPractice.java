package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _16_TargetPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimension = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[] charSnake = scanner.nextLine().toCharArray();
        int lenOfSnake = charSnake.length;
        String[][] staris = new String[dimension[0]][dimension[1]];
        int counter = 0;
        boolean goLeft = true;
        for (int row = dimension[0] - 1; row >= 0; row--) {
            if (goLeft) {
                for (int col = dimension[1] - 1; col >= 0; col--) {
                    counter = counter % lenOfSnake;
                    staris[row][col] = String.valueOf(charSnake[counter]);
                    counter++;
                }
                goLeft = false;
            } else {
                for (int col = 0; col < dimension[1]; col++) {
                    counter = counter % lenOfSnake;
                    staris[row][col] = String.valueOf(charSnake[counter]);
                    counter++;
                }
                goLeft = true;
            }
        }
        int impactRow = scanner.nextInt();
        int impactCol = scanner.nextInt();
        int radius = scanner.nextInt();
        shot(staris, impactCol, impactRow, radius);
        rearange(staris);
        StringBuilder out = new StringBuilder();
        for (String[] row : staris) {
            for (String s : row) {
                out.append(s);
            }
            out.append('\n');
        }
        System.out.println(out);
    }

    private static void rearange(String[][] staris) {
        int width = staris[0].length;
        for (int row = staris.length - 1; row >= 0; row--) {
            for (int column = 0; column < width; column++) {
                if (!staris[row][column].equals(" ")) {
                    continue;
                }
                int currentRow = row - 1;
                while (currentRow >= 0) {
                    if (!staris[currentRow][column].equals(" ")) {
                        staris[row][column] = staris[currentRow][column];
                        staris[currentRow][column] = " ";
                        break;
                    }
                    currentRow--;
                }
            }
        }
    }

    private static void shot(String[][] staris, int impactCol, int impactRow, int radius) {
        for (int row = 0; row < staris.length; row++) {
            for (int col = 0; col < staris[row].length; col++) {
                if(isInCircle(row, col, impactRow, impactCol, radius)){
                    staris[row][col] = " ";
                }
            }
        }
    }

    private static boolean isInCircle(int row, int col, int impactRow, int impactCol, int radius) {
        int deltaRow = row - impactRow;
        int deltaCol = col - impactCol;
        boolean isInRadius = deltaRow * deltaRow + deltaCol * deltaCol <= radius * radius;
        return isInRadius;
    }

}
