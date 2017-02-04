package _04_JavaAdvancedSetsAndMapsLab;

import java.util.*;

public class _06_AcademyGraduation {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();

        TreeMap<String, List<Double>> classBook = new TreeMap<>();

        for (int i = 0; i < num; i++) {
            String name = scanner.nextLine();
            String[] gradesStr = scanner.nextLine().split(" ");
            List<Double> grades = new ArrayList<>();
            for (String s : gradesStr) {
                grades.add(Double.parseDouble(s));
            }
            classBook.put(name, grades);
        }
        for (Map.Entry<String, List<Double>> student : classBook.entrySet()) {
            List<Double> grades = student.getValue();
            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            System.out.println(student.getKey() + " is graduated with " + sum / grades.size());
        }


    }
}
