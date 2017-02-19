package _07_RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([A-Za-z])\\1+";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String rep = matcher.group(1);
            matcher.appendReplacement(sb, rep);
        }
        matcher.appendTail(sb);
        System.out.println(sb);
    }
}

