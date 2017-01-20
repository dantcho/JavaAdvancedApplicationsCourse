package _02_MultidimensionalArraysLab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04_GroupNumbers {
    public static int[] convertToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static int[] readMatrix() {
        Scanner scanner = new Scanner(System.in);
        String[] strSmatrix = scanner.nextLine().split(", ");
        int[] matrix = convertToIntArray(strSmatrix);
        return matrix;
    }

    public static void main(String[] args) {

        int[] numbers = readMatrix();
        List<List<Integer>> group = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            group.add(i, new ArrayList<>());
        }
        for (int i = 0; i < numbers.length; i++) {
            int remainder = Math.abs(numbers[i] % 3);
            (group.get(remainder)).add(numbers[i]);
        }
        for (List<Integer> integerList : group) {
            StringBuilder strToPrint = new StringBuilder();
            integerList.forEach(x -> strToPrint.append(x + " "));
            System.out.println(strToPrint.toString().trim());
        }
    }
}
