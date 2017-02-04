package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> base = new TreeMap<>();
        char[] input = scanner.nextLine().toCharArray();
        for (char s : input) {
            if (base.containsKey(s)) {
                base.put(s, base.get(s) + 1);
            }else {
                base.put(s,1);
            }
        }
        for (Map.Entry<Character, Integer> pairs : base.entrySet()) {
            System.out.printf("%s: %s time/s\n",pairs.getKey(),pairs.getValue());
        }
    }
}
