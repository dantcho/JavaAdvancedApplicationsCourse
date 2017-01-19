package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _07_OddAndEvenPairs {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] stringArr = input.nextLine().split("\\s+");
        int arrSize = stringArr.length;
        if (arrSize % 2 != 0) {
            System.out.println("invalid length");
            return;
        }
        int[] intArr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        for (int i = 0; i < arrSize; i += 2) {
            if (intArr[i] % 2 == intArr[i + 1] % 2) {
                if (intArr[i]%2 == 0) {
                    System.out.printf("%d, %d -> both are even\n", intArr[i], intArr[i + 1]);

                } else {

                    System.out.printf("%d, %d -> both are odd\n", intArr[i], intArr[i + 1]);
                }

            } else {
                System.out.printf("%d, %d -> different\n", intArr[i], intArr[i + 1]);
            }

        }
    }
}
