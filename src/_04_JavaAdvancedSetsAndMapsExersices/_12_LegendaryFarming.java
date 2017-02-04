package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.Scanner;
import java.util.TreeMap;

public class _12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> keyMaterial = new TreeMap<String, Integer>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};
        TreeMap<String, Integer> junkMaterial = new TreeMap<String, Integer>();

        while (true) {
            String[] goods = scanner.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < goods.length; i += 2) {
                int quantity = Integer.parseInt(goods[i]);
                String material = goods[i + 1];
                if (keyMaterial.containsKey(material)) {
                    keyMaterial.put(material, keyMaterial.get(material) + quantity);
                    if (keyMaterial.get(material) >= 250) {
                        keyMaterial.put(material, keyMaterial.get(material) - 250);
                        StringBuilder out = new StringBuilder();
                        switch (material) {
                            case "shards":
                                out.append("Shadowmourne");
                                break;
                            case "fragments":
                                out.append("Valanyr");
                                break;
                            case "motes":
                                out.append("Dragonwrath");
                                break;
                        }
                        out.append(" obtained!\n");
                        keyMaterial
                                .entrySet()
                                .stream()
                                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                                .forEach(
                                        element -> out
                                                .append(element.getKey())
                                                .append(": ")
                                                .append(element.getValue())
                                                .append('\n'));
                        junkMaterial
                                .entrySet()
                                .forEach(
                                        element -> out
                                                .append(element.getKey())
                                                .append(": ")
                                                .append(element.getValue())
                                                .append('\n'));
                        System.out.println(out);
                        return;
                    }
                } else {
                    if (!junkMaterial.containsKey(material)) {
                        junkMaterial.put(material, quantity);
                    } else {
                        junkMaterial.put(material, junkMaterial.get(material) + quantity);
                    }
                }
            }

        }

    }
}
