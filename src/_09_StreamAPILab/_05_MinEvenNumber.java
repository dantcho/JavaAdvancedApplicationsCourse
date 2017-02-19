package _09_StreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class _05_MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        Optional<Double> min = numbers.stream()
                .filter(x -> !x.isEmpty())
                .map(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .min(Double::compare);
        if (min.isPresent()){
            System.out.println(String.format("%.2f",min.get()));
        }else {
            System.out.println("No match");
        }
    }
}
