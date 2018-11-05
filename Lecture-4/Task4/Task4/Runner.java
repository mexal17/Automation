package Task4;

public class Runner {

    private String name;
    private int time;

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getTime() {
        return time;
    }

    public Runner(String name,int time){
        this.name = name;
        this.time = time;
    }

    public void showRunner(){
        System.out.println(name+" -> "+time);
    }
}