package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Arrays;
import java.util.Scanner;

public class _21_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        boolean[][] parking = new boolean[rows][cols];
        for (boolean[] r : parking) {
            Arrays.fill(r, Boolean.TRUE);
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            String[] b = input.split(" ");
            int enterRow = Integer.parseInt(b[0]);
            int desireRow = Integer.parseInt(b[1]);
            int desireCol = Integer.parseInt(b[2]);
            int movesToParkingPlace = findParkingPlace(parking, desireRow, desireCol, enterRow);
            if (movesToParkingPlace > -1) {
                System.out.println(movesToParkingPlace);
            } else {
                System.out.println("Row " + desireRow + " full");
            }
        }
    }

    private static int findParkingPlace(boolean[][] parking, int desireRow, int desireCol, int enterRow) {
        int rowFind = desireRow, colFind = desireCol;
        boolean isFreeOnRow = false;
        if (!parking[desireRow][desireCol]) {
            boolean goLeft = false, goRight = false;
            for (int col = desireCol, adder = 0, multiplier = 1; col > 0 && col < parking[desireRow].length; ) {
                if (parking[desireRow][col]) {
                    desireCol = col;
                    isFreeOnRow = true;
                    break;
                }
                if (!goLeft || goRight) {
                    if (col == 1) {
                        goRight = true;
                        multiplier = 1;
                        adder = 1;
                    } else if (col == parking[desireRow].length - 1) {
                        goLeft = true;
                        multiplier = -1;
                        adder = 1;
                    } else {
                        if (multiplier == -1) {
                            multiplier = 1;
                        } else multiplier = -1;
                        adder++;
                    }
                }
                col = col + adder * multiplier;
            }
        } else isFreeOnRow = true;

        if (!isFreeOnRow) return -1;
        int moves = desireCol + 1 + Math.abs(desireRow - enterRow);
        parking[desireRow][desireCol] = false;
        return moves;
    }
}
