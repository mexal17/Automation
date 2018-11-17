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

    private final static String INPUT_FILE_NAME = "c:/Work folder/Automation/Lesson#8/StudentsList.txt";
    private final static String OUTPUT_FILE_NAME = "c:/Work folder/Automation/Lesson#8/OUT_PUT_StudentsList.txt";

    private static String getWordFromStringUsingRegex(String textLine, String regex ){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textLine);
        String searchedWord = null;
        if (matcher.find()){
            searchedWord = matcher.group();
        }
        return searchedWord;
    }

    private static List<Student> getListStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                String[] row = textLine.split(" ");
                students.add(new Student(students.size() + 1, row[0], row[1],
                        Integer.valueOf(row[2]), getWordFromStringUsingRegex(textLine,"\\+(375)[0-9]{9}"),
                        getWordFromStringUsingRegex(textLine,"[a-zA-z\\d\\.\\+\\-]{2,256}@[a-zA-Z]+\\.[a-z]{2,6}")));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file is not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during file reading. " + e.getMessage());
        }
        return students;
    }

    private static void printListIntoFile(String fileName, List<Student> students, String typeOperation) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true));
            bufferedWriter.write(typeOperation + "\n");
            for (Student student : students) {
                bufferedWriter.write(student.toString() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file is not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during file writing. " + e.getMessage());
        }
        try {
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error during file closing. " + e.getMessage());
        }
    }

    private static void printMapIntoFile(String fileName, Map<Integer, Student> studentMap, String typeOperation) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true));
            bufferedWriter.write(typeOperation + "\n");
            for (Map.Entry<Integer, Student> entryStudent : studentMap.entrySet()) {
                bufferedWriter.write(entryStudent.toString() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: file is not found. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during file writing. " + e.getMessage());
        }
        try {
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error during file closing. " + e.getMessage());
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

