package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.*;

public class _08_HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] inputArr = input.split(": ");
            String name = inputArr[0];
            String[] cards = inputArr[1].split(", ");
            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }
            for (String card : cards) {
                players.get(name).add(card);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, HashSet<String>> player : players.entrySet()) {
            System.out.printf("%s: %s\n", player.getKey(), calculateScore(player.getValue()));
        }
        System.out.println(players);
    }

    public static int calculateScore(HashSet<String> cards) {

        int score = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() -1);
            String type = card.substring(card.length() - 1);
            int typePower = 0;
            switch (type) {
                case "S":
                    typePower = 4;
                    break;
                case "H":
                    typePower = 3;
                    break;
                case "D":
                    typePower = 2;
                    break;
                case "C":
                    typePower = 1;
                    break;
            }
            try {
                score += Integer.parseInt(power) * typePower;
            } catch (Exception e) {
                int tmpMltpl = 0;
                switch (power) {
                    case "J":
                        tmpMltpl = 11;
                        break;
                    case "Q":
                        tmpMltpl = 12;
                        break;
                    case "K":
                        tmpMltpl = 13;
                        break;
                    case "A":
                        tmpMltpl = 14;
                        break;
                }
                score += tmpMltpl * typePower;
            }
        }
        return score;
    }
}
