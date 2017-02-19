package _09_StreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class _06_FindAndSumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        Optional<Integer> sum = numbers.stream()
                .filter(x -> isNumber(x))
                .map(Integer::valueOf)
                .reduce((x, y) -> x + y);
        if (sum.isPresent()){
            System.out.println(sum.get());
        }else System.out.println("No match");
    }

    private static boolean isNumber(String x) {
        try {
            Integer.parseInt(x);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
