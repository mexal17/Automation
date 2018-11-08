package l2task2;

import static java.lang.Math.random;

public class Group {

    private Student[] students;
    private int groupId;

    public Group(int groupId, int studentAmount) {
        this.groupId = groupId;
        createStudents(studentAmount);
    }

    public void createStudents(int studentAmount) {
        students = new Student[studentAmount];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("user_" + (int) (random() * 10), "test_" + (int) (random() * 10));
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public int getGroupId() {
        return groupId;
    }
}