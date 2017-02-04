package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String , Long> base = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String mine = input;
            if (base.containsKey(mine)) {
                base.put(mine, base.get(mine) + Long.parseLong(scanner.nextLine()));
            }else {
                base.put(mine,Long.parseLong(scanner.nextLine()));
            }
            input=scanner.nextLine();
        }
        for (Map.Entry<String,Long> pairs : base.entrySet()) {
            System.out.printf("%s -> %s\n",pairs.getKey(),pairs.getValue());
        }

    }
}
