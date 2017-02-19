package _09_StreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class _04_AverageOfDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        OptionalDouble average = numbers.stream()
                .filter(x->!x.isEmpty())
                .mapToDouble(Double::valueOf)
                .average();
        if (average.isPresent()){
            System.out.println(String.format("%.2f",average.getAsDouble()));
        }else {
            System.out.println("No match");
        }

    }
}
