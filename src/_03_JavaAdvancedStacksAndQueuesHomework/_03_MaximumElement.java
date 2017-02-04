package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer[]> minMaxStack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        minMaxStack.push(new Integer[]{min, max});
        for (int commandLine = 1; commandLine <= numberOfCommands; commandLine++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "1":
                    int intToPush = Integer.parseInt(command[1]);
                    if (intToPush > max) {
                        max = intToPush;
                    }
                    if (intToPush < min) {
                        min = intToPush;
                    }
                    stack.push(intToPush);
                    minMaxStack.push(new Integer[]{min, max});
                    break;
                case "2":
                    stack.pop();
                    minMaxStack.pop();
                    min = minMaxStack.peek()[0];
                    max = minMaxStack.peek()[1];
                    break;
                case "3":
                    System.out.println(minMaxStack.peek()[1]);
                    break;
            }
        }
    }
}
