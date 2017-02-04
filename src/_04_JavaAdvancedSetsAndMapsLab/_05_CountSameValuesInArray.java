package _04_JavaAdvancedSetsAndMapsLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_CountSameValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> base = new HashMap<>();
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            if (base.containsKey(s)) {
                base.put(s, base.get(s) + 1);
            }else {
                base.put(s,1);
            }
        }
        for (Map.Entry<String, Integer> pairs : base.entrySet()) {
            System.out.printf("%s - %s times\n",pairs.getKey(),pairs.getValue());
        }

    }
}
