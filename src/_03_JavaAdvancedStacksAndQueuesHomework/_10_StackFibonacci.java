package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _10_StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayDeque<Long> deck = new ArrayDeque<>();
        deck.push(1L);
        deck.push(1L);
        for (int i = 0; i < num-1; i++) {
            deck.push(deck.peek()+deck.pollLast());
        }
        System.out.println(deck.peek());
    }

}
