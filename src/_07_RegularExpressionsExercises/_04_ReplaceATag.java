package _07_RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "<a\\s+(href=[^>]+)>([^<]+)<\\/a>";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder input = new StringBuilder();
        while (true) {

            String in = scanner.nextLine();
            if (in.equals("END")) {
                break;
            }
            input.append(in).append("\r\n");
        }
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String rep = "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
            input.replace(matcher.start(),matcher.end(),rep);
            matcher=pattern.matcher(input);
        }
        matcher.appendTail(sb);
        System.out.println(sb);
    }
}

