package _07_RegularExpressionsExercises;

import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class _01_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([A-Z][a-z]+) ([A-Z][a-z]+)$");
        String regex = "^([A-Z][a-z]+) ([A-Z][a-z]+)$";
        String input = scanner.nextLine();
        while (!input.equals("end")){
            if(pattern.matcher(input).find()) System.out.println(input);
            input=scanner.nextLine();
        }

    }
}
