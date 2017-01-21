package _02_MultidimensionalArraysHomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _13_ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        String[][] data = new String[numberOfRows][];
        List<String> people = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            data[row] = scanner.nextLine().split(" ");
            if (!people.contains(data[row][1])) {
                people.add(data[row][1]);
            }
        }
        double[][] dataArr = new double[people.size()][12];
        for (String[] rows : data) {
            String name = rows[1];
            int month = Integer.parseInt(rows[0].split("/")[1]);
            double distance = Double.parseDouble(rows[2]);
            int indexOfName = people.indexOf(name);
            dataArr[indexOfName][month] += distance;
        }
        for (int month = 0; month < 12; month++) {
            double sumOfMonth = 0;
            for (double[] d : dataArr) {
                sumOfMonth += d[month];
            }
            if (sumOfMonth == 0) {
                continue;
            }
            System.out.printf("%d: ", month);
            String[] names = people.toArray(new String[people.size()]);
            Arrays.sort(names);
            for (String name : names) {
                int index = people.indexOf(name);
                if (dataArr[index][month] > 0) {
                    System.out.printf("%s(%d)", name, (long) dataArr[index][month]);
                }else continue;
                dataArr[index][month] = 0;
                sumOfMonth = 0;
                for (double[] d : dataArr) {
                    sumOfMonth += d[month];
                }
                if (sumOfMonth == 0) {
                    System.out.printf("\n");
                } else {
                    System.out.printf(", ");
                }
            }
        }
    }
}
