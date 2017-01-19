package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _08_HitTheTarget {
    static int chooseNumbers = 2;
    static int allNumbers = 21;
    static int target;
    static int[] arr = new int[chooseNumbers];

    public static void generateVariations(int index)
    {
        if (index >= chooseNumbers)
        {
            chekTarget();
        }
        else
            for (int i = 1; i < allNumbers; i++)
            {
                arr[index] = i;
                generateVariations(index + 1);
            }
    }

    static void chekTarget() {
        if (arr[0] + arr[1] == target) {
            System.out.printf("%d + %d = %d\n", arr[0], arr[1], target);
        }
        if (arr[0] - arr[1] == target) {
            System.out.printf("%d - %d = %d\n", arr[0], arr[1], target);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        target = input.nextInt();
        generateVariations(0);
    }
}
