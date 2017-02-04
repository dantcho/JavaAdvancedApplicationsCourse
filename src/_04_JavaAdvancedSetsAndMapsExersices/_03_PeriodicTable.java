package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        TreeSet<String > elementsSet = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            String[] elRow = scanner.nextLine().split(" ");
            for (String s : elRow) {
                elementsSet.add(s);
            }
        }
        StringBuilder out = new StringBuilder();

        for (String element : elementsSet) {
            out.append(element).append(" ");
        }
        System.out.println(out.toString().trim());
    }
}
