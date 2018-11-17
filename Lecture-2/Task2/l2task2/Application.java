package l2task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Application {

    private static Student[] createStudents(int studentAmount) {
        Student[] students = new Student[studentAmount];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("user_" + ThreadLocalRandom.current().nextInt(10),
                    "test_" + ThreadLocalRandom.current().nextInt(10));
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
        return tickets[ThreadLocalRandom.current().nextInt(tickets.length)];
    }

    private static int getRandomScore() {
        return ThreadLocalRandom.current().nextInt(1, 6);
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
        for (ExamAnswer examAnswer : exam.getExamAnswers()) {
            System.out.println(examAnswer);
        }
    }

    private static void showMediumGroupScore(Exam exam) {
        int sumOfAllScores = 0;
        for (ExamAnswer examAnswer : exam.getExamAnswers()) {
            sumOfAllScores += examAnswer.getScore();
        }
        System.out.println("Medium score of " + exam.getGroup() + " is "
                + (double) sumOfAllScores / exam.getExamAnswers().size());
    }

    private static int bestScoreInGroupExam(Exam exam) {
        int bestScore = 1;
        for (ExamAnswer examAnswer : exam.getExamAnswers()) {
            bestScore = Math.max(examAnswer.getScore(), bestScore);
        }
        return bestScore;
    }

    private static void showStudentsByScores(int score, Exam exam) {
        for (ExamAnswer examAnswer : exam.getExamAnswers()) {
            if (examAnswer.getScore() == score) {
                System.out.println("the best student " + examAnswer.getStudent() +
                        " got score " + examAnswer.getScore());
            }
        }
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
