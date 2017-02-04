package _03_JavaAdvancedStacksAndQueuesHomework;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08_BalancedParentheses {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        char[] input = scaner.nextLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque();
        boolean isBalanced = true;
        for (char c : input) {
            if (!isBalanced) {
                break;
            }
            char open;
            try {


                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        open = stack.pop();
                        if (open != '(') {
                            isBalanced = false;
                        }
                        break;
                    case '}':
                        open = stack.pop();
                        if (open != '{') {
                            isBalanced = false;
                        }
                        break;
                    case ']':
                        open = stack.pop();
                        if (open != '[') {
                            isBalanced = false;
                        }
                        break;
                }
            } catch (Exception e) {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else System.out.println("NO");

    }
}
