package _09_StreamAPIExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_OfficeStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("\\|([^ \\-]+) - ([^ \\-]+) - ([^ \\-|]+)\\|");
        TreeMap<String, LinkedHashMap<String, Integer>> base = new TreeMap<>();

        for (int row = 0; row < rows; row++) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while (matcher.find()) {
                String company = matcher.group(1);
                int quantity = Integer.valueOf(matcher.group(2));
                String product = matcher.group(3);
                if (!base.containsKey(company)) {
                    base.put(company, new LinkedHashMap<String, Integer>());
                    base.get(company).put(product, quantity);
                } else {
                    if (!base.get(company).containsKey(product)) {
                        base.get(company).put(product, quantity);
                    } else {
                        base.get(company).put(product, base.get(company).get(product) + quantity);
                    }
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (Map.Entry<String, LinkedHashMap<String, Integer>> companyList : base.entrySet()) {
            out.append(companyList.getKey()).append(": ");
            StringJoiner j = new StringJoiner(", ");
            companyList.getValue().forEach((product, quantity) -> j.add(product + "-" + quantity));
            out.append(j).append("\n");
        }
        System.out.println(out);
    }
}

