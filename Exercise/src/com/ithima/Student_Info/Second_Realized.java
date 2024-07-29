package com.ithima.Student_Info;

import java.util.ArrayList;

public class Second_Realized implements Realized{
    @Override
    public void print_Info(ArrayList<Student> s) {
        int n  = s.size();
        int male =0;
        int female = 0;
        for(int i = 0;i<n;i++){
            Student temp = s.get(i);
            System.out.println("name:"+temp.getName());
            System.out.println("gender:"+temp.getGender());
            if(temp.getGender().equals("男")) male++;
            else female++;

        }
        System.out.println("男性有:"+male+"人");
        System.out.println("女性有:"+female+"人");
    }
    @Override
    public void print_average_score(ArrayList<Student> s) {
        double sum = 0;
        double max = -1;
        double min = 101;
        int n = s.size();
        for(int i = 0;i<n;i++){
            Student temp = s.get(i);
            sum += temp.getScore();
            if(temp.getScore()<min)min = temp.getScore();
            if(temp.getScore()>max)max = temp.getScore();
        }
        sum -=max;
        sum -=min;
        sum /=(n-2);
        System.out.println("Average score:"+sum);
    }


}
