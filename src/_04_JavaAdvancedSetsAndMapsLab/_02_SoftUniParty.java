package _04_JavaAdvancedSetsAndMapsLab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> partyList = new TreeSet<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("PARTY")) break;
            partyList.add(input);
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("END")) break;
            partyList.remove(input);
        }
        System.out.println(partyList.size());
        for (String car : partyList) {
            System.out.println(car);
        }


    }
}
