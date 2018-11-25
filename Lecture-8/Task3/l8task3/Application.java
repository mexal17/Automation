package l8task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {

    private final static String INPUT_FILE_NAME = "resources/StudentsList.txt";
    private final static String OUTPUT_FILE_NAME = "resources/OUT_PUT_StudentsList.txt";
    private final static String PHONE_NUMBER_PATTERN = "\\+(375)[0-9]{9}";
    private final static String EMAIL_PATTERN = "[a-zA-z\\d\\.\\+\\-]{2,256}@[a-zA-Z]+\\.[a-z]{2,6}";

    private static String getWordFromStringUsingRegex(String textLine, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textLine);
        String searchedWord = null;
        if (matcher.find()) {
            searchedWord = matcher.group();
        }
        return searchedWord;
    }

    private static List<Student> getListStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                String[] row = textLine.split(" ");
                students.add(new Student(students.size() + 1, row[0], row[1],
                        Integer.valueOf(row[2]), getWordFromStringUsingRegex(textLine, PHONE_NUMBER_PATTERN),
                        getWordFromStringUsingRegex(textLine, EMAIL_PATTERN)));
            }
        } catch (IOException e) {
            System.out.println("Error during file reading. " + e.getMessage());
        }
        return students;
    }

    private static void printListIntoFile(String fileName, List<Student> students, String typeOperation) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true))) {
            bufferedWriter.write(typeOperation + "\n");
            for (Student student : students) {
                bufferedWriter.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error during file writing. " + e.getMessage());
        }
    }

    private static void printMapIntoFile(String fileName, Map<Integer, Student> studentMap, String typeOperation) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true))) {
            bufferedWriter.write(typeOperation + "\n");
            for (Map.Entry<Integer, Student> entryStudent : studentMap.entrySet()) {
                bufferedWriter.write(entryStudent.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error during file writing. " + e.getMessage());
        }
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

    private static Map<Integer, Student> getMapOfStudents(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getId, student -> student));
    }

    private static Map<Integer, Student> getStudentsWithOlderAge(Map<Integer, Student> studentMap, int age) {
        return studentMap.entrySet().stream().filter(student -> student.getValue().getAge() > age).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        List<Student> students = getListStudentsFromFile(INPUT_FILE_NAME);
        showStudents(students);
        printListIntoFile(OUTPUT_FILE_NAME, getSortedStudentsByAge(students), "SortedStudentsByAge:");
        printListIntoFile(OUTPUT_FILE_NAME, getSortedStudentsByLastName(students), "SortedStudentsByLastName:");
        printMapIntoFile(OUTPUT_FILE_NAME, getMapOfStudents(students), "MapOfStudents:");
        printMapIntoFile(OUTPUT_FILE_NAME, getStudentsWithOlderAge(getMapOfStudents(students), 30), "StudentsWithOlderAge > 30:");
    }
}

