package _04_JavaAdvancedSetsAndMapsLab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _03_VoinaNumberGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> player1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> player2 = new LinkedHashSet<>();
        String[] in = scanner.nextLine().split("\\s+");
        for (String s : in) {
            player1.add(Integer.parseInt(s));
        }
        in = scanner.nextLine().split("\\s+");
        for (String s : in) {
            player2.add(Integer.parseInt(s));
        }
        int turn = 0;
        while (turn < 50) {
            turn++;
            int pl1Card = player1.iterator().next(), pl2Card = player2.iterator().next();
            player1.remove(pl1Card);
            player2.remove(pl2Card);
            if (pl1Card > pl2Card) {
                player1.add(pl1Card);
                player1.add(pl2Card);

            } else if (pl1Card < pl2Card) {
                player2.add(pl1Card);
                player2.add(pl2Card);
            } else {
                player1.add(pl1Card);
                player2.add(pl2Card);
            }
            if (player1.isEmpty() || player2.isEmpty()) {
                break;
            }
        }
        if (player1.size() > player2.size()) {
            System.out.println("First player win!");
        } else if (player1.size() < player2.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw");
        }

    }
}
