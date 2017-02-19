package _09_StreamAPIExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        Path studentPath = Paths.get("c:\\Users\\dancho\\Documents\\GitHub\\JavaAdvancedApplicationsCourse\\src\\_09_StreamAPIExercises\\StudentData.txt");
        List<String> data = new ArrayList<>();
        try {
            data = Files.readAllLines(studentPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Student> students = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] token = data.get(i).split("\\s+");

            String facNum = token[0];
            String firstName = token[1];
            String lastName = token[2];
            String email = token[3];
            String phone = token[10];
            int age = Integer.parseInt(token[4]);
            int group = Integer.parseInt(token[5]);
            List<Integer> grades = new ArrayList<>();

            for (int j = 6; j <= 9; j++) {
                grades.add(Integer.parseInt(token[j]));
            }
            students.add(new Student(facNum, firstName, lastName, email, age, group, grades, phone));
        }

//        studentsByGroup(students);
//        studentsByFirstAndLastName(students);
//        studentsByAge(students);
//        sortStudents(students);
//        filterStudentsByEmailDomain(students);
        filterStudentsByPhone(students);
//        excellentStudents(students);
//        weakStudents(students);
//        studentsByEnrollmentYear(students);
    }

    private static void studentsByEnrollmentYear(List<Student> students) {
        Map<Integer, List<Student>> studentsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        s -> Integer.valueOf(
                                s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2)
                        )
                ));
        studentsByYear.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .forEach(s -> {
                    s.getValue().sort((o1, o2) ->
                            (o1.getFirstName()+o1.getLastName()).compareTo((o2.getFirstName()+o2.getLastName())));
                    StringBuilder out = new StringBuilder();
                    out.append("20").append(s.getKey()).append(":\n");
                    s.getValue().forEach(student -> out
                            .append("-- ")
                            .append(student.getFirstName())
                            .append(" ")
                            .append(student.getLastName())
                            .append("\n")
                    );

                    System.out.print(out);
                });
    }

    private static void weakStudents(List<Student> students) {
        students.stream()
                .filter(student -> studentContainsMoreThenTwoWeakMarks(student))
                .sorted((o1, o2) -> sortWeakStudents(o1, o2))
                .forEach(student -> printStdentGradesDes(student));
    }

    private static void printStdentGradesDes(Student student) {
        StringBuilder out = new StringBuilder();
        out
                .append(student.getFirstName())
                .append(" ")
                .append(student.getLastName())
                .append(" ");

        student.getGrades().sort((o1, o2) -> o1.compareTo(o2));
        for (Integer integer : student.getGrades()) {
            out.append(integer).append(" ");
        }
        System.out.println(out);
    }

    private static int sortWeakStudents(Student o1, Student o2) {
        int sum1 = o1.getGrades().stream().mapToInt(Integer::valueOf).sum();
        int sum2 = o2.getGrades().stream().mapToInt(Integer::valueOf).sum();
        return (int) (sum1 - sum2);
    }

    private static boolean studentContainsMoreThenTwoWeakMarks(Student student) {
        int countOfWeakMarks = 0;
        List<Integer> grades = student.getGrades();
        for (Integer grade : grades) {
            if (grade <= 3) countOfWeakMarks++;
        }
        if (countOfWeakMarks >= 2) return true;
        else return false;
    }

    private static void excellentStudents(List<Student> students) {
        students.stream()
                .filter(student -> student.getGrades().contains(6))
                .forEach(student -> printStdentGrades(student));

    }

    private static void printStdentGrades(Student student) {
        StringBuilder out = new StringBuilder();
        out
                .append(student.getFirstName())
                .append(" ")
                .append(student.getLastName())
                .append(" ");

        student.getGrades().sort((o1, o2) -> o2.compareTo(o1));
        for (Integer integer : student.getGrades()) {
            out.append(integer).append(" ");
        }
        System.out.println(out);

    }

    private static void filterStudentsByEmailDomain(List<Student> students) {
        students.stream()
                .filter(student -> student.getEmail().endsWith("gmail.com"))
                .forEach(student -> System.out.printf("%s %s %s\n", student.getFirstName(), student.getLastName(), student.getEmail()));
    }

    private static void sortStudents(List<Student> students) {
        students.stream()
                .sorted(((o1, o2) -> {
                    int i = o1.getLastName().compareTo(o2.getLastName());
                    if (i == 0) {
                        return o2.getFirstName().compareTo(o1.getFirstName());
                    } else return i;
                }))
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
    }

    private static void studentsByAge(List<Student> students) {
        students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 24)
                .forEach(student -> System.out.printf("%s %s %s\n", student.getFirstName(), student.getLastName(), student.getAge()));
    }

    private static void studentsByFirstAndLastName(List<Student> students) {
        students.stream()
                .filter(student -> student.getFirstName().compareTo(student.getLastName()) < 0)
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
    }

    private static void studentsByGroup(List<Student> students) {
        students.stream()
                .filter(student -> student.getGroup() == 2)
                .sorted(((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName())))
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
    }

    private static void filterStudentsByPhone(List<Student> students) {
        students.stream()
                .filter(student -> student.getPhone().startsWith("02") || student.getPhone().startsWith("+3592"))
                .forEach(student -> System.out.printf("%s %s %s\n", student.getFirstName(), student.getLastName(), student.getPhone()));
    }
}
