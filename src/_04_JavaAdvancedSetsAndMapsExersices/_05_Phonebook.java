package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.HashMap;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] person = input.split("-");
            phonebook.put(person[0], person[1]);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            String nameToFind = input;
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n", nameToFind, phonebook.get(nameToFind));
            } else {
                System.out.printf("Contact %s does not exist.\n", nameToFind);
            }
            input = scanner.nextLine();
        }

    }
}
