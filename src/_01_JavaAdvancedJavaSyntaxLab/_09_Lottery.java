package _01_JavaAdvancedJavaSyntaxLab;

public class _09_Lottery {
    static int chooseNumbers = 3;
    static int allNumbers = 10;
    static int[] arr = new int[chooseNumbers];

    public static void main(String[] args) {
        makeCombination(0, 1);
    }

    public static void makeCombination(int index, int start) {
        if (index >= chooseNumbers) {
            PrintCombinations();
        } else
            for (int i = start; i <= allNumbers; i++) {
                arr[index] = i;
                makeCombination(index + 1, i + 1);
            }
    }

    static void PrintCombinations() {
        System.out.printf("%d", arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.printf(" %d", arr[i]);
        }
        System.out.println();
    }
}

