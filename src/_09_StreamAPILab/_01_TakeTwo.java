package _09_StreamAPILab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_TakeTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        Arrays.stream(tokens)
                .map(x -> Integer.parseInt(x))
                .filter(x -> x >= 10 && x <= 20)
                .distinct()
                .limit(2)
                .forEach(x-> System.out.print(x+" "));
    }
}
