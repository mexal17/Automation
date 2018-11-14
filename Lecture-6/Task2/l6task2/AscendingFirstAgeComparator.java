package l6task2;

import java.util.Comparator;

public class AscendingFirstAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.valueOf(student1.getAge()).compareTo(Integer.valueOf(student2.getAge()));
    }
}
