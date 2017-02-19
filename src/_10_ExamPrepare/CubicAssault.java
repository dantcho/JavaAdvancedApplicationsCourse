package _10_ExamPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashMap<String, HashMap<String, Long>> enemies = new HashMap<>();
        while (!input.equals("Count em all")) {
            String[] token = input.split(" -> ");
            String name = token[0];
            String metrorit = token[1];
            Integer quantity = Integer.parseInt(token[2]);
            if (!enemies.containsKey(name)) {
                enemies.put(name, new HashMap<>());
                enemies.get(name).put("Red", 0L);
                enemies.get(name).put("Black", 0L);
                enemies.get(name).put("Green", 0L);
            }
            enemies.get(name).put(metrorit, enemies.get(name).get(metrorit) + quantity);

            long greenMetors = enemies.get(name).get("Green");
            if (greenMetors >= 1000000) {
                long addToRed = greenMetors / 1000000;
                enemies.get(name).put("Green", greenMetors - addToRed * 1000000);
                enemies.get(name).put("Red", enemies.get(name).get("Red") + addToRed);
            }
            long redMetors = enemies.get(name).get("Red");
            if (redMetors >= 1000000) {
                long addToBlack = redMetors / 1000000;
                enemies.get(name).put("Red", redMetors - addToBlack * 1000000);
                enemies.get(name).put("Black", enemies.get(name).get("Black") + addToBlack);
            }
            input = reader.readLine();
        }

        StringBuilder out = new StringBuilder();
        enemies.entrySet().stream()
                .sorted((o1, o2) -> srt(o1, o2))
                .forEach(x -> {
                    out.append(x.getKey()).append('\n');
                    x.getValue().entrySet().stream()
                            .sorted((o1, o2) -> s(o1, o2))
                            .forEach(y -> out.append("-> ").append(y.getKey()).append(" : ").append(y.getValue()).append('\n'));
                });
        System.out.println(out);
    }

    private static int s2(Map.Entry<String, Long> m1, Map.Entry<String, Long> m2) {

        if (Long.compare(m2.getValue(), m1.getValue()) == 0) {
            return m1.getKey().compareTo(m2.getKey());
        }
        return Long.compare(m2.getValue(), m1.getValue());
    }

    private static int s(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
        if (Long.compare(o1.getValue(), o2.getValue()) == 0) {
            return o1.getKey().compareTo(o2.getKey());
        } else return Long.compare(o2.getValue(), o1.getValue());
    }


    private static int srt2(Map.Entry<String, HashMap<String, Long>> r1, Map.Entry<String, HashMap<String, Long>> r2) {

        if (Long.compare(
                r2.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue(),
                r1.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue()) == 0) {
            if (Integer.compare(r1.getKey().length(), r2.getKey().length()) == 0) {
                return r1.getKey().compareTo(r2.getKey());
            }
            return ((Integer) r1.getKey().length()).compareTo(r2.getKey().length());
        }
        return Long.compare(
                r2.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue(),
                r1.getValue().entrySet().stream().filter(m -> m.getKey().equals("Black")).findFirst().get().getValue());
    }

    private static int srt(Map.Entry<String, HashMap<String, Long>> o1, Map.Entry<String, HashMap<String, Long>> o2) {
        if (o1.getValue().get("Black") == o2.getValue().get("Black")) {
            if (o1.getKey().length() == o2.getKey().length()) {
                return o1.getKey().compareTo(o2.getKey());
            } else return Integer.compare(o1.getKey().length(), o2.getKey().length());
        } else return Long.compare(o2.getValue().get("Black"), o1.getValue().get("Black"));
    }


}
