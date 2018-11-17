package l2task2;

import java.util.List;

public class Exam {
    private final Group group;
    private List<ExamAnswer> examAnswers;

    public Exam(Group group, List<ExamAnswer> examAnswers) {
        this.group = group;
        this.examAnswers = examAnswers;
    }

    public Group getGroup() {
        return group;
    }

    public List<ExamAnswer> getExamAnswers() {
        return examAnswers;
    }
}
