package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int adds = scanner.nextInt();
        int polls = scanner.nextInt();
        int intToFind = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int add = 0; add < adds; add++) {
            stack.add(scanner.nextInt());
        }
        for (int poll = 0; poll < polls; poll++) {
            stack.poll();
        }
        if (stack.contains(intToFind)) {
            System.out.println("true");
            return;
        }
        Object[] sortedArr = stack.toArray();
        Arrays.sort(sortedArr);
        if (sortedArr.length != 0) {
            System.out.println(sortedArr[0]);
        }else System.out.println(0);
    }
}
