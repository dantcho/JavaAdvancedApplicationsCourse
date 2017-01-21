package _03_JavaAdvancedStacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _06_MathPotato {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue,children);

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            if (isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int n) {
        if (n==1||n==0){
            return false;
        }
        // fast even test.
        if(n > 2 && (n & 1) == 0)
            return false;
        // only odd factors need to be tested up to n^0.5
        for(int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

}
