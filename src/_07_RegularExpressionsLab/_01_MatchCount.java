package _07_RegularExpressionsLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_MatchCount {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Pattern pattern =
                Pattern.compile(reader.nextLine());
        Matcher matcher =
                pattern.matcher(reader.nextLine());

        int count = 0;
        while (matcher.find())
            count++;

        System.out.println(count);
    }
}
