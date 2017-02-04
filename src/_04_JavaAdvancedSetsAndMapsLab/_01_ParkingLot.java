package _04_JavaAdvancedSetsAndMapsLab;

import java.util.HashSet;
import java.util.Scanner;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashSet<String> parkingLot = new HashSet<String>();
        while (!input.equals("END")) {
            String[] command = input.split(", ");
            switch (command[0]) {
                case "IN":
                    parkingLot.add(command[1]);
                    break;
                case "OUT":
                    parkingLot.remove(command[1]);
                    break;
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }

    }
}
