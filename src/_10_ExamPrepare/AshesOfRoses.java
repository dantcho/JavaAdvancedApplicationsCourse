package _10_ExamPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String regex = "\\b^Grow\\s<([A-Z][a-z]+)>\\s<([A-Za-z0-9]+)>\\s(\\d+)$";
        Pattern pattern = Pattern.compile(regex);
        TreeMap<String, TreeMap<String, Long>> regions = new TreeMap<>();
        while (!input.equals("Icarus, Ignite!")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String regionName = matcher.group(1);
                String colorName = matcher.group(2);
                Integer quantity = Integer.valueOf(matcher.group(3));

                if (!regions.containsKey(regionName)) {
                    regions.put(regionName, new TreeMap<>());
                    regions.get(regionName).put(colorName, (long) quantity);
                } else {
                    if (!regions.get(regionName).containsKey(colorName)) {
                        regions.get(regionName).put(colorName, (long) quantity);
                    } else {
                        regions.get(regionName).put(colorName, regions.get(regionName).get(colorName) + quantity);
                    }
                }
            }
            input =reader.readLine();
        }
        StringBuilder out = new StringBuilder();
        regions.entrySet().stream()
                .sorted((o1, o2) -> Long.compare(o2.getValue().entrySet().stream().mapToLong(x -> x.getValue()).sum(), o1.getValue().entrySet().stream().mapToLong(x -> x.getValue()).sum()))
                .forEach(x -> {
                    out.append(x.getKey()).append('\n');
                    x.getValue().entrySet().stream()
                            .sorted((o1, o2) -> Long.compare(o1.getValue(), o2.getValue()))
                            .forEach(y -> {
                                out.append("*--")
                                        .append(y.getKey()).append(" | ")
                                        .append(y.getValue()).append('\n');
                            });
                });
        System.out.println(out);
    }

}
