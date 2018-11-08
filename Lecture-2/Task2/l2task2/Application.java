package l2task2;

import static java.lang.Math.random;

public class Application {

    private static Ticket[] createTickets(int amount) {
        Ticket[] tickets = new Ticket[amount];
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = new Ticket(i + 1, "Theme #" + (i + 1));
        }
        return tickets;
    }

    private static Ticket[] distributeTickets(int studentsAmount, Ticket[] tickets) {
        Ticket[] distributedTickets = new Ticket[studentsAmount];
        for (int i = 0; i < distributedTickets.length; i++) {
            distributedTickets[i] = tickets[(int) (random() * (tickets.length - 1) + 1)];
        }
        return distributedTickets;
    }

    private static int[] divideScores(int studentsAmount) {
        int[] scores = new int[studentsAmount];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = (int) (random() * 5 + 1);
        }
        return scores;
    }

    private static void showExamResults(Exam exam) {
        System.out.println("Exam results of Group #" + exam.getGroup().getGroupId() + "->");
        for (int i = 0; i < exam.getGroup().getStudents().length; i++) {
            System.out.println(exam.getGroup().getStudents()[i].toString() + " got ticket= "
                    + exam.getTickets()[i].toString() + " and score= "
                    + exam.getScores()[i]);
        }
    }

    private static void showMediumGroupScore(Exam exam) {
        int sum = 0;
        for (int score : exam.getScores()) {
            sum += score;
        }
        double mediumScore = (double) sum / exam.getScores().length;
        System.out.println("Medium score of Group#" + exam.getGroup().getGroupId() + " is " + mediumScore);
    }

    private static int bestScoreInGroup(int[] scores) {
        int bestScore = 1;
        for (int score : scores) {
            bestScore = Math.max(score, bestScore);
        }
        return bestScore;
    }

    private static void showStudentsByScores(int score, Exam exam) {
        for (int i = 0; i < exam.getGroup().getStudents().length; i++) {
            if (exam.getScores()[i] == score) {
                System.out.println("the best student " + exam.getGroup().getStudents()[i].toString() +
                        " got score " + exam.getScores()[i]);
            }
        }
    }

    public static void main(String[] args) {

        Group group1 = new Group(1, 5);
        Group group2 = new Group(2, 5);
        Ticket[] tickets = createTickets(10);
        Exam firstExam = new Exam(distributeTickets(group1.getStudents().length, tickets), group1, divideScores(group1.getStudents().length));
        Exam secondExam = new Exam(distributeTickets(group2.getStudents().length, tickets), group2, divideScores(group2.getStudents().length));

        showExamResults(firstExam);
        showExamResults(secondExam);
        showMediumGroupScore(firstExam);
        showMediumGroupScore(secondExam);
        int maxScore = Math.max(bestScoreInGroup(firstExam.getScores()), bestScoreInGroup(secondExam.getScores()));
        showStudentsByScores(maxScore, firstExam);
        showStudentsByScores(maxScore, secondExam);
    }
}
