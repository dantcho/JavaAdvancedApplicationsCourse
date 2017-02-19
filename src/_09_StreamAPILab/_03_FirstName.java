package _09_StreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class _03_FirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));
        List<String> letters = Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+"));
        Optional<String> first = names
                .stream()
                .filter(x -> letters.contains(String.valueOf(x.toLowerCase().charAt(0))))
                .sorted()
                .findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("No match");
        }
    }
}
