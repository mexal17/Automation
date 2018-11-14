package l2task2;

public class Exam {
    private final Ticket[] tickets;
    private final Group group;
    private final int[] scores;

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
