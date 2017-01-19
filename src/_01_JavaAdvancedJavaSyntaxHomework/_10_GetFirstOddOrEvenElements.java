package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _10_GetFirstOddOrEvenElements {
    public static void printOdd(int[] arr, int count) {
        int index = 0;
        int size = arr.length;
        int cnt = 0;
        String result = "";
        while (index < size && cnt < count) {
            if (arr[index] % 2 != 0) {
                result = result + arr[index] + " ";
                cnt++;
            }
            index++;
        }
        System.out.println(result.trim());
    }

    public static void printEven(int[] arr, int count) {
        int index = 0;
        int size = arr.length;
        int cnt = 0;
        String result = "";
        while (index < size && cnt < count) {
            if (arr[index] % 2 == 0) {
                result = result + arr[index] + " ";
                cnt++;
            }
            index++;
        }
        System.out.println(result.trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsAsString = scanner.nextLine().split("\\s+");
        String[] commandArgs = scanner.nextLine().split("\\s+");
        int[] numsAsInt = new int[numsAsString.length];
        for (int i = 0; i < numsAsString.length; i++) {
            numsAsInt[i] = Integer.parseInt(numsAsString[i]);
        }
        int getN = Integer.parseInt(commandArgs[1]);
        switch (commandArgs[2]) {
            case "odd":
                printOdd(numsAsInt, getN);
                break;
            case "even":
                printEven(numsAsInt, getN);
                break;
        }

    }
}
