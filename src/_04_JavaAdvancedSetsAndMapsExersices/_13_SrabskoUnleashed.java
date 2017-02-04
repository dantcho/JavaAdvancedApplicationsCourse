package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(^(?:\\w+ ){1,3})@((?:\\w+ ){1,3})(\\d+) (\\d+)");
        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> venueBase = new LinkedHashMap<>();

        while (!input.equals("End")) {

            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singer = matcher.group(1).trim();
                String venue = matcher.group(2).trim();
                int tichetPrice = Integer.parseInt(matcher.group(3));
                int ticketsCount = Integer.parseInt(matcher.group(4));
                if (!venueBase.containsKey(venue)) {
                    venueBase.put(venue, new LinkedHashMap<String, Integer>() {{
                        put(singer, tichetPrice * ticketsCount);
                    }});
                } else {
                    if (!venueBase.get(venue).containsKey(singer)) {
                        venueBase.get(venue).put(singer, tichetPrice * ticketsCount);
                    } else {
                        venueBase.get(venue).put(singer, venueBase.get(venue).get(singer) + tichetPrice * ticketsCount);
                    }
                }
            }
            input = scanner.nextLine();
        }
        StringBuilder out = new StringBuilder();
        venueBase.forEach((ven, list) -> {
            {
                out.append(ven + "\n");
                list.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(x -> out.append("#  ").append(x.getKey()).append(" -> ").append(x.getValue()).append('\n'));
            }
        });
        System.out.println(out);
    }
}
