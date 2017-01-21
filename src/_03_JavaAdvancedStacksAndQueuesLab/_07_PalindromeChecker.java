package _03_JavaAdvancedStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palindromeCandidate = scanner.nextLine();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (char c : palindromeCandidate.toCharArray())
            queue.offer(c);
        boolean isPalindrome = true;
        while (queue.size() > 1) {
            char first = queue.poll();
            char last = queue.pollLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);

    }
}
