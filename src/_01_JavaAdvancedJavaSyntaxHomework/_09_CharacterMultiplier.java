package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _09_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        long sum = 0L;
        int str1Len = str1.length();
        int str2Len = str2.length();
        int countSingleMultiply = Math.abs(str1Len - str2Len);

        if (str1Len > str2Len) {
            int index=0;
            for (int i = 0; i < str1Len - countSingleMultiply; i++) {
                sum += str1.charAt(i) * str2.charAt(i);
                index = i;
            }
            for (int i = index + 1; i < str1Len; i++) {
                sum += str1.charAt(i);
            }
        } else {
            int index=0;
            for (int i = 0; i < str2Len - countSingleMultiply; i++) {
                sum += str1.charAt(i) * str2.charAt(i);
                index = i;
            }
            for (int i = index + 1; i < str2Len; i++) {
                sum += str2.charAt(i);
            }

        }
        System.out.println(sum);
    }
}
