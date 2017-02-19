package _09_StreamAPILab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_UpperStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        Arrays.stream(tokens)
                .forEach(x-> System.out.print(x.toUpperCase()+" "));
    }
}
