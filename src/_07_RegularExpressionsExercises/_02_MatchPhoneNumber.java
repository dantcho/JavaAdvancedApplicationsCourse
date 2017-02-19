package _07_RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^\\+359( |-)2\\1\\d{3}\\1\\d{4}$";
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            if (Pattern.matches(regex, input)) System.out.println(input);
            input = scanner.nextLine();
        }
    }
}
