package _09_StreamAPIExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _11_LittleJohn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] messageInDec = new int[3];
        Pattern pattern = Pattern.compile("(>>>-{5}>>)|(>>-{5}>)|(>-{5}>)");

        for (int row = 0; row < 4; row++) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while (matcher.find()) {
                if (matcher.group(1) != null) messageInDec[2]++;
                if (matcher.group(2) != null) messageInDec[1]++;
                if (matcher.group(3) != null) messageInDec[0]++;
            }
        }
        String secNum = messageInDec[0] + "" + messageInDec[1] + "" + messageInDec[2];
        String secNumInBin = Integer.toBinaryString(Integer.parseInt(secNum));
        char[] firstPart = secNumInBin.toCharArray();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < firstPart.length; i++) {
            out.append(firstPart[i]);
        }
        for (int i = firstPart.length - 1; i > -1; i--) {
            out.append(firstPart[i]);
        }
        System.out.println(Integer.parseInt(out.toString(),2));
    }
}
