package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> populationByCountry = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String country = data[1], city = data[0];
            Long population = Long.parseLong(data[2]);
            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<String, Long>() {{
                    put(city, population);
                }});
                populationByCountry.put(country, population);
            } else {
                countries.get(country).put(city, population);
                populationByCountry.put(country, populationByCountry.get(country) + population);
            }

            input = scanner.nextLine();
        }
        countries.entrySet().stream()
                .sorted((c1, c2) -> populationByCountry.get(c2.getKey()).compareTo(populationByCountry.get(c1.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)\n", country.getKey(), populationByCountry.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> {
                        System.out.format("=>%s: %d\n", city.getKey(), city.getValue());
                    });
                });
    }
}
