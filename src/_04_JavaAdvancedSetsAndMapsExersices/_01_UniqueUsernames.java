package _04_JavaAdvancedSetsAndMapsExersices;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> passwords = new LinkedHashSet<>();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            passwords.add(scanner.nextLine());
        }
        for (String password : passwords) {
            System.out.println(password);
        }
    }
}
