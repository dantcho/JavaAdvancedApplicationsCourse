package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _07_TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<int[]> pumps = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] pairStr = scanner.nextLine().split(" ");
            int[] pair = Arrays.stream(pairStr).mapToInt(Integer::parseInt).toArray();
            pumps.add(pair);
        }
        for (int i = 0; i < n; i++) {
            int fuel = 0;
            for (int[] pump : pumps) {
                fuel += pump[0];
                fuel -= pump[1];
                if (fuel < 0) {
                    break;
                }
            }
            if (fuel < 0) {
                pumps.add(pumps.pop());
            } else {
                System.out.println(i);
                return;
            }
        }

    }
}
