package _03_JavaAdvancedStacksAndQueuesHomework;
//Only 88/100 points
import java.util.*;

public class _15_PoisonousPlants {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plants = Integer.parseInt(scanner.nextLine());
        int dayOfDeaths = 0;
        int cycles = 0;
        int lastCycles = cycles;
        int smallest = Integer.MAX_VALUE;
        int left = smallest;
        int smallerFromCycle = left;
        boolean isCycleStarted = false;
        for (int i = 0; i < plants; i++) {
            int plant = scanner.nextInt();
            if (isCycleStarted) {
                if (plant <= smallest) {
                    smallest = plant;
                    cycles = 0;
                    isCycleStarted=false;
                } else if (plant <= smallerFromCycle) {
                    smallerFromCycle = plant;
                    cycles++;
                }else if(plant<=left){
                    lastCycles++;
                }else {
                    lastCycles=1;
                }
            } else {
                if (plant > left) {
                    lastCycles = cycles;
                    cycles = 1;
                    isCycleStarted = true;
                    smallerFromCycle = plant;
                } else if (plant <= smallest) {
                    smallest = plant;
                    cycles = 0;
                }

            }
            if (lastCycles>cycles){
                cycles=lastCycles;
            }
            if (cycles > dayOfDeaths) {
                dayOfDeaths = cycles;
            }
            left = plant;
        }
        System.out.println(dayOfDeaths);
    }
}
