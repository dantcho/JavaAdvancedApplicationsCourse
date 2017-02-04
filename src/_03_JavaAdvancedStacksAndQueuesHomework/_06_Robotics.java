package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_Robotics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robots = scanner.nextLine().split(";");
        int[] robotTime = new int[robots.length];
        String[] robotNames = new String[robots.length];
        boolean[] robotFree = new boolean[robots.length];
        long[] robotStartTime = new long[robots.length];
        for (int robot = 0; robot < robots.length; robot++) {
            String[] temp = robots[robot].split("-");
            robotNames[robot] = temp[0];
            int time = Integer.parseInt(temp[1]);
            if (time == 0) {
                robotTime[robot] = 1;
            } else robotTime[robot] = time;
            robotFree[robot] = true;
        }
        String[] starTime = scanner.nextLine().split(":");
        long time = (Integer.parseInt(starTime[0]) * 60 * 60) + (Integer.parseInt(starTime[1]) * 60) + (Integer.parseInt(starTime[2]));
        ArrayDeque<String> deque = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            deque.add(product);
            product = scanner.nextLine();
        }
        while (!deque.isEmpty()) {
            time++;
            String productForProcess = deque.poll();
            boolean willProcessed = false;
            for (int robot = 0; robot < robotFree.length; robot++) {
                if (!robotFree[robot]) {
                    long finishTime = robotStartTime[robot];
                    finishTime+=robotTime[robot];
                    if (time-finishTime >= 0) {
                        robotFree[robot] = true;
                    }
                }
                if (robotFree[robot]) {
                    willProcessed = true;
                    robotFree[robot] = false;
                    robotStartTime[robot] = time;
                    System.out.printf("%s - %s %s\n", robotNames[robot], productForProcess, timeDisplay(time));
                    break;
                }
            }
            if (!willProcessed) {
                deque.add(productForProcess);
            }

        }
    }
    private static String timeDisplay(long currentSeconds) {

        long hours = ((int) (currentSeconds / 3600)) % 24;
        long remainder = currentSeconds % 3600;
        long minutes = remainder / 60;
        long seconds = remainder % 60;

        String currentTime = String.format("[%02d:%02d:%02d]", hours, minutes, seconds);

        return currentTime;    }
}
