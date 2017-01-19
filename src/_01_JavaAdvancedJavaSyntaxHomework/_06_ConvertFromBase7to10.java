package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _06_ConvertFromBase7to10 {

    public static String baseConversion(String number, int base1, int base2){
        return Integer.toString(Integer.parseInt(number, base1), base2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.next();
        String convertedNumber = baseConversion(number,7 ,10);
        System.out.println(convertedNumber);
    }
}

