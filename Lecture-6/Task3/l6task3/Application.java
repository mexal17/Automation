package l6task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    private static String[] firstNames = {"Kate", "Bob", "Roy", "Jane", "Tom", "Nick", "Ann", "Jack", "Eva", "Adam"};
    private static String[] lastNames = {"Smith", "Jeff", "Little", "Black", "Bush", "Neal", "Owen", "Ryder", "Ford", "Gill"};

    private static int getRandomAge() {
        return (int) (Math.random() * 50 + 20);
    }

    private static void showStudents(List<Student> students) {
        students.stream().forEach(System.out::println);
    }

    private static List<Student> getSortedStudentsByAge(List<Student> students) {
        return students.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
    }

    private static List<Student> getSortedStudentsByLastName(List<Student> students) {
        return students.stream().sorted(Comparator.comparing(Student::getLastName)).collect(Collectors.toList());
    }

    private static List<Student> getStudentsByFirstLetterInLastName(String letter, List<Student> students) {
        return students.stream().filter(student -> student.getLastName().substring(0, 1).toLowerCase().equals(letter.toLowerCase()))
                .collect(Collectors.toList());
    }

    private static double getMediumStudentAge(List<Student> students) {
        return students.stream().map(Student::getAge).reduce(0, (sum, age) -> sum + age) / (double) students.size();
    }

    private static Map<Integer, Student> getMapOfStudents(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getId, student -> student));
    }

    private static void showMapOfStudents(Map<Integer, Student> studentMap) {
        studentMap.entrySet().stream().forEach(System.out::println);
    }

    private static Map<Integer, Student> getStudentsWithOlderAge(Map<Integer, Student> studentMap, int age) {
        return studentMap.entrySet().stream().filter(student -> student.getValue().getAge() > age).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < firstNames.length; i++) {
            students.add(new Student(i + 1, firstNames[i], lastNames[i], getRandomAge()));
        }
        showStudents(students);
        System.out.println("-------> getSortedStudentsByAge:");
        showStudents(getSortedStudentsByAge(students));
        System.out.println("-------> getSortedStudentsByLastName:");
        showStudents(getSortedStudentsByLastName(students));
        System.out.println("-------> getStudentsByFirstLetterInLastName:");
        showStudents(getStudentsByFirstLetterInLastName("b", students));
        System.out.println("-------> MediumStudentAge:");
        System.out.println(getMediumStudentAge(students));
        System.out.println("-------> getMapOfStudents:");
        showMapOfStudents(getMapOfStudents(students));
        System.out.println("-------> getStudentsWithOlderAge:");
        showMapOfStudents(getStudentsWithOlderAge(getMapOfStudents(students), 50));
    }
}