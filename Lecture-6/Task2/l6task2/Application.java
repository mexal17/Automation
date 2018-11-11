package l6task2;

import java.util.*;

public class Application {

    private static String[] firstNames = {"Kate", "Bob", "Roy", "Jane", "Tom", "Nick", "Ann", "Jack", "Eva", "Adam"};
    private static String[] lastNames = {"Smith", "Jeff", "Little", "Black", "Bush", "Neal", "Owen", "Ryder", "Ford", "Gill"};

    private static int getRandomAge() {
        return (int) (Math.random() * 50 + 20);
    }

    private static List<Student> sortStudentsByAge(List<Student> students) {
        Collections.sort(students, new FirstAgeComparator());
        return students;
    }

    private static void showStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> getStudentsByFirstLetterInLastName(String letter, List<Student> students) {
        List<Student> sortedStudents = new ArrayList<>();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getLastName().substring(0, 1).toLowerCase().equals(letter.toLowerCase())) {
                sortedStudents.add(student);
            }
        }
        return sortedStudents;
    }

    private static double getMediumStudentAge(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        int summaryAge = 0;
        while (iterator.hasNext()) {
            summaryAge += iterator.next().getAge();
        }
        return ((double) summaryAge) / students.size();
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < firstNames.length; i++) {
            students.add(new Student(i + 1, firstNames[i], lastNames[i], getRandomAge()));
        }
        showStudents(students);
        System.out.println("-----> sortStudentsByAge:");
        showStudents(sortStudentsByAge(students));
        System.out.println("-----> getStudentsByFirstLetterInLastName:");
        showStudents(getStudentsByFirstLetterInLastName("b", students));
        System.out.println("-----> MediumStudentAge = " + getMediumStudentAge(students));
    }
}
