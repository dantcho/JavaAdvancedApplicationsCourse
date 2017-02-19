package _10_ExamPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubicsMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!input.equals("Over!")) {
            int numOfChars = Integer.valueOf(reader.readLine());
            String regex = "^(\\d+)([A-Za-z]{" + numOfChars + "})([^A-Za-z]*)$";
            if (input.matches(regex)) {
                Matcher matcher = Pattern.compile(regex).matcher(input);
                while (matcher.find()) {
                    String digit = matcher.group(1) + matcher.group(3);
                    String secret = matcher.group(2);
                    String out = getVerificationCode(secret, digit);
                    System.out.println(secret + " == " + out);
                }
            }

            input = reader.readLine();
        }
    }

    private static String decrypt(String secret, String digit) {
        int secLen = secret.length();
        StringBuilder out = new StringBuilder();
        List<String> ts = Arrays.asList(digit.split(""));
        List<Integer> collect = ts.stream()
                .filter(s -> Character.isDigit(s.charAt(0)))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        for (Integer dig : collect) {
            if (dig >= secLen) {
                out.append(" ");
                continue;
            }
            out.append(secret.charAt(dig));
        }
        return out.toString();
    }
    private static String getVerificationCode(String validMessage, String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int index = Integer.parseInt(str.charAt(i) + "");
                if (0 <= index && index < validMessage.length()) {
                    result += validMessage.charAt(index);
                    continue;
                }
            }
            result += " ";
        }

        return result;
    }
}
