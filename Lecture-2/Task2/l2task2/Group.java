package l2task2;

public class Group {

    private Student[] students;
    private final int groupId;

    public Group(int groupId, Student[] students) {
        this.groupId = groupId;
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return "Group #" + groupId;
    }
}