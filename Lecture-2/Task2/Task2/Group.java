package Task2;

import static java.lang.Math.random;

public class Group {

    private Student[] students;
    private int[] scores;

    public Group(int studentsAmount, int scoresAmount){
        students = new Student[studentsAmount];
        scores = new int[scoresAmount];
    }

    public void setGroupStudents(){
        for (int i = 0; i< students.length; i++) {
            students[i] = new Student();
            students[i].setName("user_" + (int)(random()*10));
            students[i].setLastName("test_" + (int)(random()*10));
        }
    }

    public Student [] getGroupStudents(){
        return students;
    }

    public int[] getGroupScores(){
        return scores;
    }
}