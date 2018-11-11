package l6task2;

import java.util.Comparator;

public class FirstAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        Integer age1 = student1.getAge();
        Integer age2 = student2.getAge();
        return age1.compareTo(age2);
    }
}
