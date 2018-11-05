package Task2;

import static java.lang.Math.max;
import static java.lang.Math.random;

public class Application {

    private static Ticket[] createTickets(int amount){
        Ticket[] tickets = new Ticket[amount];
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = new Ticket();
            tickets[i].setId(i+1);
            tickets[i].setQuestion("Question #"+(i+1));
        }
        return tickets;
    }

    private static void divideTickets(Student[] students, Ticket[] tickets){
        for (Student student:students) {
            student.setTicket(tickets[(int)(random()*9) +1]);
        }
    }

    private static void divideScores(Student[] students, int[] scores){
        for (int i = 0; i < 5; i++) {
            scores[i] = (int)(random()*5+1);
            students[i].setScore(scores[i]);
        }
    }

    private  static void showDividedScores(Student[] students){
        for (Student student: students) {
            System.out.println(student.getName()+" "+student.getLastName()+" got score="+student.getScore());
        }
    }

    private static void showTicketsAndScores(Student[] students, int groupNumber){
        System.out.println("Group #"+groupNumber);
        for (Student student:students) {
            System.out.println(student.getName()+" "+student.getLastName()+" got ticket="+student.getTicket().getQuestion()+" and score="+student.getScore());
        }
    }

    private static void showMediumScore(Student[] students){
        int sum = 0;
        for (Student student:students) {
            sum+=student.getScore();
        }
        double mediumScore = (double)sum/students.length;
        System.out.println("medium score is " + mediumScore);
    }

    private static int bestScoreInGroup(int[] scores){
        int bestScore = 1;
        for (int score:scores){
            if (bestScore < score){
                bestScore = score;
            }
        }
        return bestScore;
    }

    private static void showStudentsWithScore(int score, Student[] students){
        for (Student student: students){
            if (student.getScore() == score){
                System.out.println("the best student is "+student.getName()+" "+student.getLastName()+" got "+student.getScore());
            }
        }
    }

    public static void main(String[] args) {

        Group group1 = new Group(5,5);
        Group group2 = new Group(5,5);

        // создаем студентов
        group1.setGroupStudents();
        group2.setGroupStudents();

        //создаем билеты
        Ticket[] tickets = createTickets(10);

        //распределение рандомных билетов
        divideTickets(group1.getGroupStudents(), tickets);
        divideTickets(group2.getGroupStudents(), tickets);

        // распределяем оценки
        divideScores(group1.getGroupStudents(),group1.getGroupScores());
        divideScores(group2.getGroupStudents(),group2.getGroupScores());

        //вывод оценок и билетов
        showTicketsAndScores(group1.getGroupStudents(),1);
        showTicketsAndScores(group2.getGroupStudents(),2);

        //средняя оценка
        showMediumScore(group1.getGroupStudents());
        showMediumScore(group2.getGroupStudents());

        int maxScore = max(bestScoreInGroup(group1.getGroupScores()),bestScoreInGroup(group2.getGroupScores()));

        showStudentsWithScore(maxScore,group1.getGroupStudents());
        showStudentsWithScore(maxScore,group2.getGroupStudents());

    }
}
