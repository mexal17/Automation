package Task2;

public class Student {
    private String name;
    private String lastName;
    private Ticket ticket;
    private int score;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}