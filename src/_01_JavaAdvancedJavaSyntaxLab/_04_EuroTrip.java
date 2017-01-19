package _01_JavaAdvancedJavaSyntaxLab;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class _04_EuroTrip {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        double quantity = scanner.nextDouble();
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInLeva = new BigDecimal(1.2 * quantity);
        BigDecimal priceOfWurstInMarks = priceInLeva.multiply(exchangeRate);
        System.out.printf("%.2f marks", priceOfWurstInMarks);
    }
}
