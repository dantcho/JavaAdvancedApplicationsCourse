package _02_MultidimensionalArraysHomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String in = scanner.nextLine();
        String rotateStr = in;
        int endIndex = rotateStr.indexOf(')');
        int rotateDeg = Integer.parseInt(rotateStr.substring(7, endIndex));
        in = scanner.nextLine();
        int longest = 0;
        while (!in.equals("END")) {
            if (in.length() > longest) {
                longest = in.length();
            }
            input.add(in);
            in = scanner.nextLine();
        }
        int height = input.size();
        char[][] arrayToRotate = new char[height][longest];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < longest; col++) {
                try {
                    arrayToRotate[row][col] = input.get(row).charAt(col);
                } catch (Exception e) {
                    arrayToRotate[row][col] = ' ';
                }
            }
        }
        int rotateTimes = (rotateDeg / 90) % 4;
        char[][] rotatedArray;
        if (rotateTimes % 2 == 0) {
            rotatedArray = new char[height][longest];
            if (rotateTimes == 2) {
                for (int row = 0; row < height; row++) {
                    for (int col = 0; col < longest; col++) {
                        rotatedArray[height - row - 1][longest - col - 1] = arrayToRotate[row][col];
                    }
                }
            } else rotatedArray = arrayToRotate;
        } else {
            rotatedArray = new char[longest][height];
            if (rotateTimes == 1) {
                for (int row = 0; row < height; row++) {
                    for (int col = 0; col < longest; col++) {
                        rotatedArray[col][height - row - 1] = arrayToRotate[row][col];
                    }
                }
            } else {
                for (int row = 0; row < height; row++) {
                    for (int col = 0; col < longest; col++) {
                        rotatedArray[longest - col - 1][row] = arrayToRotate[row][col];
                    }
                }
            }
        }
        for (int row = 0; row < rotatedArray.length; row++) {
            for (int col = 0; col < rotatedArray[row].length; col++) {
                System.out.print(rotatedArray[row][col]);
            }
            System.out.println();
        }

    }
}
