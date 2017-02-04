package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.*;

public class _14_DragonArmy {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragonArmy = new LinkedHashMap<>();
        for (int i = 0; i < rows; i++) {
            String[] data = scanner.nextLine().split(" ");
            String dragonType = data[0];
            String dragonName = data[1];
            int damage, health, armor;
            try {
                damage = Integer.parseInt(data[2]);
            } catch (Exception e) {
                damage = 45;
            }
            try {
                health = Integer.parseInt(data[3]);
            } catch (Exception e) {
                health = 250;
            }
            try {
                armor = Integer.parseInt(data[4]);
            } catch (Exception e) {
                armor = 10;
            }

            if (!dragonArmy.containsKey(dragonType)) {
                dragonArmy.put(dragonType, new TreeMap<>());
            }
            dragonArmy.get(dragonType).put(dragonName, new int[]{damage, health, armor});
        }
        StringBuilder out = new StringBuilder();
        dragonArmy.forEach((type, family) -> {
            {
                int allDamage = 0, allHealth = 0, allArmor = 0, allDragons = family.size();
                StringBuilder helper = new StringBuilder();

                for (Map.Entry<String, int[]> entry : family.entrySet()) {
                    helper
                            .append("-").append(entry.getKey()).append(" -> ")
                            .append("damage: ").append(entry.getValue()[0])
                            .append(", health: ").append(entry.getValue()[1])
                            .append(", armor: ").append(entry.getValue()[2])
                            .append('\n');
                    allDamage += entry.getValue()[0];
                    allHealth += entry.getValue()[1];
                    allArmor += entry.getValue()[2];
                }
                out.append(type)
                        .append("::(")
                        .append(String.format("%.2f/%.2f/%.2f", (double) allDamage / (double) allDragons, (double) allHealth / (double) allDragons, (double) allArmor / (double) allDragons))
                        .append(")\n")
                        .append(helper);
            }
        });
        System.out.println(out);

    }
}
