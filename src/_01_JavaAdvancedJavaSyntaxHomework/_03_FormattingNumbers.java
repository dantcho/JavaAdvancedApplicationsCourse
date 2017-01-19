package _01_JavaAdvancedJavaSyntaxHomework;

import java.util.Locale;
import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        int a;
        double b, c;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextDouble();
        c = input.nextDouble();
        System.out.printf("|%-10X|%10s|%10.2f|%-10.3f|", a, String.format("%10s", Integer.toBinaryString(a)).replace(' ', '0'), b, c);
    }
}
