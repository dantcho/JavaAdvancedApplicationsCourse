package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] intToReverse = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String c : intToReverse)
            stack.push(Integer.parseInt(c));
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()){
                System.out.print(" ");
            }
        }
    }
}
