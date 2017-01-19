package _01_JavaAdvancedJavaSyntaxHomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _12_VehiclePark {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> carToSell = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        String input = scanner.nextLine();
        int soldVe = 0;
        while (!input.equals("End of customers!")) {
            String[] i = input.split(" ");
            String model = String.valueOf(i[0].charAt(0)).toLowerCase();
            int seat = Integer.parseInt(i[2]);

            String searchCriteria = model + seat;
            int whereToFind = carToSell.indexOf(searchCriteria);
            if (whereToFind >= 0) {
                System.out.printf("Yes, sold for %d$\n", (int) model.charAt(0) * seat);
                carToSell.remove(whereToFind);
                soldVe++;
            } else System.out.println("No");
            input=scanner.nextLine();
        }
        StringBuilder carLeft = new StringBuilder();
        for (String s : carToSell)
        {
            carLeft.append(s);
            carLeft.append(", ");
        }

        System.out.println("Vehicles left: " + carLeft.subSequence(0,carLeft.length()-2));
        System.out.printf("Vehicles sold: %d", soldVe);
    }
}

