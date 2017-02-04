package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pushes = scanner.nextInt();
        int pops = scanner.nextInt();
        int intTofind = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int push = 0; push < pushes; push++) {
            stack.push(scanner.nextInt());
        }
        for (int pop = 0; pop < pops; pop++) {
            stack.pop();
        }
        if (stack.contains(intTofind)) {
            System.out.println("true");
            return;
        }
        int stackSize = stack.size();
        int[] sortedArr = new int[stackSize];
        for (int pos = 0; pos < stackSize; pos++) {
            sortedArr[pos] = stack.pop();
        }
        Arrays.sort(sortedArr);
        if (sortedArr.length != 0) {
            System.out.println(sortedArr[0]);
        }else System.out.println(0);
    }
}
