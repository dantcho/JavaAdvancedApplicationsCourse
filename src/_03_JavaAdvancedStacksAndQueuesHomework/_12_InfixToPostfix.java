package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.Scanner;
import java.util.Stack;

public class _12_InfixToPostfix {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infix = scanner.nextLine();
       // System.out.printf("infix:   %s%n", infix);
        System.out.println(infixToPostfix(infix));
    }

    static String infixToPostfix(String infix) {
        final String ops = "-+/*^";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (String token : infix.split("\\s")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (stack.isEmpty())
                    stack.push(idx);

                else {
                    while (!stack.isEmpty()) {
                        int prec2 = stack.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(stack.pop())).append(' ');
                        else break;
                    }
                    stack.push(idx);
                }
            } else if (c == '(') {
                stack.push(-2); // -2 stands for '('
            } else if (c == ')') {
                // until '(' on stack, pop operators.
                while (stack.peek() != -2)
                    sb.append(ops.charAt(stack.pop())).append(' ');
                stack.pop();
            } else {
                sb.append(token).append(' ');
            }
        }
        while (!stack.isEmpty())
            sb.append(ops.charAt(stack.pop())).append(' ');
        return sb.toString();
    }
}


