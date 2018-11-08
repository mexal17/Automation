package l2task2;

public class Ticket {
    private int id;
    private String question;

    public Ticket(int id, String question) {
        this.id = id;
        this.question = question;
    }

    @Override
    public String toString() {
        return "id= " + id + ", Question= " + question;
    }
}