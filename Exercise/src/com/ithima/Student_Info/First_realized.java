package com.ithima.Student_Info;
import java.util.ArrayList;
public class First_realized implements Realized{
    @Override
    public void print_Info(ArrayList<Student> s) {
        int n  = s.size();

        for(int i = 0;i<n;i++){
            Student temp = s.get(i);
            System.out.println("name:"+temp.getName());
            System.out.println("gender:"+temp.getGender());

        }

    }

    @Override
    public void print_average_score(ArrayList<Student> s) {
        double sum = 0;
        int n = s.size();
        for(int i = 0;i<n;i++){
            Student temp = s.get(i);
            sum += temp.getScore();
        }
        sum /=n;
        System.out.println("Average score:"+sum);
    }



}
