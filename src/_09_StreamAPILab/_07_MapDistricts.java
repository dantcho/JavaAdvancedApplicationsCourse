package _09_StreamAPILab;

import java.util.*;
import java.util.stream.Stream;

public class _07_MapDistricts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cities = Arrays.asList(scanner.nextLine().split("\\s+"));
        int givenPopulation = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Integer>> base = new HashMap<>();
        cities.stream().forEach(x -> {
            String[] data = x.split(":");
            if (!base.containsKey(data[0])) {
                base.put(data[0], new ArrayList<Integer>() );
                base.get(data[0]).add(Integer.parseInt(data[1]));
            } else base.get(data[0]).add(Integer.parseInt(data[1]));
        });
        base.entrySet().stream()
                .filter(x -> x.getValue()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum() > givenPopulation)
                .sorted((x, y) ->
                        y.getValue().stream().mapToInt(Integer::valueOf).sum()-
                        x.getValue().stream().mapToInt(Integer::valueOf).sum()
                )
                .forEach(x -> {
                    System.out.print(x.getKey() + ": ");
                    x.getValue().stream()
                            .sorted((s1, s2) -> s2-s1)
                            .limit(5)
                            .forEach(dp -> System.out.print(dp + " "));
                    System.out.println();
                });
    }
}
