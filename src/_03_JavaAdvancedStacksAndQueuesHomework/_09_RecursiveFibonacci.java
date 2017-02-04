package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.Scanner;

public class _09_RecursiveFibonacci {
    static long[] dictionary;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        dictionary = new long[num+1];
        if (dictionary.length == 1)
            dictionary[0] = 1;
        if (dictionary.length > 1) {
            dictionary[0] = 1;
            dictionary[1] = 1;
        }
        System.out.println(getFibonacci(num));
    }

    public static long getFibonacci(int n) {
        if (n == 0) {
            // special case because fib(0) is 0
            return dictionary[0];
        } else {
            long f = dictionary[n];
            if (f == 0) {
                // number wasn't calculated yet.
                f = getFibonacci(n - 1) + getFibonacci(n - 2);
                dictionary[n] = f;
            }
            return f;
        }
    }
}

