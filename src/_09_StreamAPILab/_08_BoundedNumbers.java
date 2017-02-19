package _09_StreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _08_BoundedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowest = scanner.nextInt();
        int highest = scanner.nextInt();
        if (lowest > highest) {
            lowest = lowest ^ highest;
            highest = lowest ^ highest;
            lowest = lowest ^ highest;
        }
        scanner.nextLine();
        int finalLowest = lowest;
        int finalHighest = highest;
        Stream.of(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(x -> x >= finalLowest && x <= finalHighest)
                .forEach(x -> System.out.print(x + " "));

    }
}
