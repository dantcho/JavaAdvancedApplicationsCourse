package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long start = scanner.nextLong();
        ArrayDeque<Long> stack = new ArrayDeque<>();
        ArrayDeque<Long> sequence = new ArrayDeque<>();
        stack.push(start);
        sequence.add(start);
        while (sequence.size()<=50){
            long first = stack.peekLast()+1;
            long second = (2*stack.peekLast())+1;
            long third = stack.peekLast()+2;
            stack.push(first);
            stack.push(second);
            stack.push(third);
            stack.pollLast();
            sequence.add(first);
            sequence.add(second);
            sequence.add(third);
        }
        for (int i = 0; i < 49; i++) {
            System.out.printf("%d ",sequence.remove());
        }
        System.out.print(sequence.remove());
    }
}
