package _01_JavaAdvancedJavaSyntaxLab;

import java.math.BigDecimal;
import java.util.Scanner;

public class _06_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double kilometers = scanner.nextDouble();
        scanner.nextLine();
        String timeOfDay = scanner.next();
        BigDecimal price = new BigDecimal("0");
        if (kilometers < 20) {
            price = price.add(new BigDecimal("0.70"));
            if (timeOfDay.equals("day")) {
                price = price.add(new BigDecimal(kilometers * 0.79));
            } else {
                price = price.add(new BigDecimal(kilometers * 0.90));
            }
        } else if (kilometers >= 20 && kilometers < 100) {
            price = price.add(new BigDecimal(kilometers * 0.09));
        } else if (kilometers >= 100) {
            price = price.add(new BigDecimal(kilometers * 0.06));
        }
        System.out.printf("%.2f", price);
    }
}
