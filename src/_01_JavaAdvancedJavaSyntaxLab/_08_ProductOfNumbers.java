package _01_JavaAdvancedJavaSyntaxLab;

import java.math.BigInteger;
import java.util.Scanner;

public class _08_ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fromInt = scanner.nextInt();
        int toInt = scanner.nextInt();
        BigInteger product =new BigInteger("1");
        for (int i = fromInt; i <= toInt; i++) {
            product = product.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.printf("product[%d..%d] = %d",fromInt,toInt,product);

    }
}
