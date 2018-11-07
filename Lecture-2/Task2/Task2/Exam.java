package Task2;

public class Exam {
    private Ticket [] tickets;
    private Group group;
    private int [] scores;

    public Exam(Ticket[] tickets, Group group, int[] scores) {
        this.tickets = tickets;
        this.group = group;
        this.scores = scores;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public int[] getScores() {
        return scores;
    }

    public Group getGroup() {
        return group;
    }
}
