package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> addresBook = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String name = input;
            String eMail = scanner.nextLine();
            String[] domainArr = eMail.split("\\.");
            String domain = domainArr[domainArr.length - 1].toLowerCase();
            if (!(domain.equals("us") || domain.equals("com") || domain.equals("uk"))) {
                addresBook.put(name, eMail);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> pairs : addresBook.entrySet()) {
            System.out.printf("%s -> %s\n", pairs.getKey(), pairs.getValue());
        }
    }
}
