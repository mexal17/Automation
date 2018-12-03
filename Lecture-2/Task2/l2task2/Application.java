package l2task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Application {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static Student[] createStudents(int studentAmount) {
        Student[] students = new Student[studentAmount];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("user_" + RANDOM.nextInt(10),
                    "test_" + RANDOM.nextInt(10));
        }
        return students;
    }

    private static Ticket[] createTickets(int amount) {
        Ticket[] tickets = new Ticket[amount];
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = new Ticket(i + 1, "Theme #" + (i + 1));
        }
        return tickets;
    }

    private static Ticket getRandomTicket(Ticket[] tickets) {
        return tickets[RANDOM.nextInt(tickets.length)];
    }

    private static int getRandomScore() {
        return RANDOM.nextInt(1, 6);
    }

    private static List<ExamAnswer> getExamAnswers(Student[] students, Ticket[] tickets) {
        List<ExamAnswer> examAnswers = new ArrayList<>();
        for (Student student : students) {
            examAnswers.add(new ExamAnswer(student, getRandomTicket(tickets), getRandomScore()));
        }
        return examAnswers;
    }

    private static void showExamResults(Exam exam) {
        System.out.println("Exam results of " + exam.getGroup() + "->");
        exam.getExamAnswers().forEach(System.out::println);
    }

    private static void showMediumGroupScore(Exam exam) {
        int sumOfAllScores = exam.getExamAnswers().stream().map(ExamAnswer::getScore).reduce(0, (sum, score) -> sum + score);
        System.out.println("Medium score of " + exam.getGroup() + " is " + (double) sumOfAllScores / exam.getExamAnswers().size());
    }

    private static int bestScoreInGroupExam(Exam exam) {
        return exam.getExamAnswers().stream().mapToInt(ExamAnswer::getScore).max().getAsInt();
    }

    private static void showStudentsByScores(int score, Exam exam) {
        exam.getExamAnswers().stream().filter(examAnswer -> examAnswer.getScore() == score).forEach(examAnswer ->
                System.out.println("the best student " + examAnswer.getStudent() + " got score " + examAnswer.getScore()));
    }

    public static void main(String[] args) {
        Group group1 = new Group(1, createStudents(5));
        Group group2 = new Group(2, createStudents(5));
        Ticket[] tickets = createTickets(10);
        Exam firstExam = new Exam(group1, getExamAnswers(group1.getStudents(), tickets));
        Exam secondExam = new Exam(group2, getExamAnswers(group2.getStudents(), tickets));
        showExamResults(firstExam);
        showExamResults(secondExam);
        showMediumGroupScore(firstExam);
        showMediumGroupScore(secondExam);
        int maxScore = Math.max(bestScoreInGroupExam(firstExam), bestScoreInGroupExam(secondExam));
        showStudentsByScores(maxScore, firstExam);
        showStudentsByScores(maxScore, secondExam);
    }
}