package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setLen = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> nSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> mSet = new LinkedHashSet<>();
        for (int i = 0; i < setLen[0]; i++) {
            nSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < setLen[1]; i++) {
            mSet.add(Integer.parseInt(scanner.nextLine()));
        }
        StringBuilder out = new StringBuilder();
        if (mSet.size() > nSet.size()) {
            for (Integer element : nSet) {
                if (mSet.contains(element)) {
                    out.append(element).append(" ");
                }
            }
        } else {
            for (Integer element : mSet) {
                if (nSet.contains(element)) {
                    out.append(element).append(" ");
                }
            }
        }
        System.out.println(out.toString().trim());
    }
}
