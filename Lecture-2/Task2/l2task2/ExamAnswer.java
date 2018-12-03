package l2task2;

public class ExamAnswer {
    private final Student student;
    private final Ticket ticket;
    private final int score;

    public ExamAnswer(Student student, Ticket ticket, int score) {
        this.student = student;
        this.ticket = ticket;
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "" + student + " got ticket = " + ticket +
                " and score = " + score;
    }
}
