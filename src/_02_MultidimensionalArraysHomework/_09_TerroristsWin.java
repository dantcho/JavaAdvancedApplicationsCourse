package _02_MultidimensionalArraysHomework;

import java.util.Scanner;

public class _09_TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] message = scanner.nextLine().toCharArray();
        boolean bombTime = false;
        int bombStart = 0;
        for (int i = 0; i < message.length; i++) {
            if (message[i] == '|') {
                if (bombTime) {
                    explodeBomb(message, bombStart, i);
                    bombTime = false;
                } else {
                    bombStart = i;
                    bombTime = true;
                }
            }
        }
        for (char c : message) {
            System.out.print(c);
        }
    }

    private static void explodeBomb(char[] message, int bombStart, int bombEnd) {
        int power = 0;
        for (int i = bombStart + 1; i < bombEnd; i++) {
            power += message[i];
        }
        power = power % 10;
        int startLimit = bombStart - power;
        int stopLimit = bombEnd + power+1;
        if (startLimit < 0) {
            startLimit = 0;
        }
        if (stopLimit > message.length) {
            stopLimit = message.length;
        }
        for (int i = startLimit; i < stopLimit; i++) {
            message[i] = '.';
        }
    }
}
