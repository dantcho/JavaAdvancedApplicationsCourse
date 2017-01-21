package _02_MultidimensionalArraysHomework;

import java.util.Locale;
import java.util.Scanner;

public class _12_ToTheStars {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        String[] stars = new String[3];
        double[][] starCoordinate = new double[3][2];
        double[] shipCoordinate = new double[2];
        for (int line = 0; line < 3; line++) {
            stars[line] = scanner.next().toLowerCase();
            starCoordinate[line][0] = scanner.nextDouble();
            starCoordinate[line][1] = scanner.nextDouble();
            scanner.nextLine();
        }
        shipCoordinate[0] = scanner.nextDouble();
        shipCoordinate[1] = scanner.nextDouble();
        scanner.nextLine();
        int moves = scanner.nextInt();
        String momentPlace = "space";
        while (moves >= 0) {
            for (int line = 0; line < 3; line++) {
                double[] coordinate = starCoordinate[line];
                if (coordinate[0] - 1 <= shipCoordinate[0] && coordinate[0] + 1 >= shipCoordinate[0] && coordinate[1] - 1 <= shipCoordinate[1] && coordinate[1] + 1 >= shipCoordinate[1]) {
                    momentPlace = stars[line];
                    break;

                } else momentPlace = "space";
            }
            System.out.println(momentPlace);
            shipCoordinate[1]++;
            moves--;
        }

    }
}
