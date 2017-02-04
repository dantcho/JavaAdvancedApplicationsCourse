package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _14_StockSpanProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < days; i++) {
            int dayPrice = Integer.parseInt(scanner.nextLine());
            stack.push(dayPrice);
            int dayWithLessPrice = 0;
            for (Integer price : stack) {
                if (price <= dayPrice) {
                    dayWithLessPrice++;
                } else break;
            }
            out.append(dayWithLessPrice).append('\n');
        }
        System.out.println(out);
    }
}
