package l6task2;

import java.util.Comparator;

public class FirstAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getAge() - student2.getAge();
    }
}
