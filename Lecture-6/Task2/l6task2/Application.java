package l6task2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Application {

    private static String[] firstNames = {"Kate", "Bob", "Roy", "Jane", "Tom", "Nick", "Ann", "Jack", "Eva", "Adam"};
    private static String[] lastNames = {"Smith", "Jeff", "Little", "Black", "Bush", "Neal", "Owen", "Ryder", "Ford", "Gill"};

    private static int getRandomAge() {
        return ThreadLocalRandom.current().nextInt(20,70);
    }

    private static List<Student> sortStudentsByAge(List<Student> students) {
        Collections.sort(students, new AscendingFirstAgeComparator());
        return students;
    }

    private static List<Student> sortStudentsByLastName(List<Student> students) {
        Collections.sort(students, new AscendingLastNameComparator());
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

    private static Map<Integer, Student> getStudentMap(List<Student> students) {
        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        for (Student student : students) {
            studentMap.put(student.getId(), student);
        }
        return studentMap;
    }

    private static void showStudentMap(Map<Integer, Student> studentMap) {
        Iterator<Map.Entry<Integer, Student>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Student> entry = iterator.next();
            System.out.println("id = " + entry.getKey() + ", " + entry.getValue());
        }
    }

    private static Map<Integer, Student> getStudentsWithOlderAge(List<Student> students, int age) {
        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        for (Student student : students) {
            if (student.getAge() > age) {
                studentMap.put(student.getId(), student);
            }
        }
        return studentMap;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < firstNames.length; i++) {
            students.add(new Student(i + 1, firstNames[i], lastNames[i], getRandomAge()));
        }
        showStudents(students);
        System.out.println("-----> sortStudentsByAge:");
        showStudents(sortStudentsByAge(students));
        System.out.println("-----> sortStudentsByLastName:");
        showStudents(sortStudentsByLastName(students));
        System.out.println("-----> getStudentsByFirstLetterInLastName:");
        showStudents(getStudentsByFirstLetterInLastName("b", students));
        System.out.println("-----> MediumStudentAge = " + getMediumStudentAge(students));
        System.out.println("-----> showStudentMap:");
        showStudentMap(getStudentMap(students));
        System.out.println("-----> showStudentWithOlderAge = 35 :");
        showStudentMap(getStudentsWithOlderAge(students, 35));
    }
}
