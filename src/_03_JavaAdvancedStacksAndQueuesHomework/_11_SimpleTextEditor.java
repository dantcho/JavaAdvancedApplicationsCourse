package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.*;

public class _11_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        StringBuilder text = new StringBuilder();
        ArrayDeque<StringBuilder> history = new ArrayDeque<>();
        history.push(text);
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "1":
                    StringBuilder appendToStr = new StringBuilder(history.peek());
                    appendToStr.append(command[1]);
                    history.push(appendToStr);
                    break;
                case "2":
                    StringBuilder deletePartOfStr = new StringBuilder(history.peek());
                    int end = deletePartOfStr.length();
                    int start = end - Integer.parseInt(command[1]);
                    deletePartOfStr.delete(start, end);
                    history.push(deletePartOfStr);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(history.peek().charAt(index-1));
                    break;
                case "4":
                    history.pop();
                    break;
            }
        }

    }
}
