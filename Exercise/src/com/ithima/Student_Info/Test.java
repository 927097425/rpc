package com.ithima.Student_Info;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
        ArrayList<Student>  stu_list = new ArrayList<>();
        stu_list.add(new Student("张三","男",100));
        stu_list.add(new Student("李三","男",80));
        stu_list.add(new Student("王三","男",70));
        stu_list.add(new Student("赵五","女",60));
        stu_list.add(new Student("笨比","男",0));
        Realized f = new Second_Realized();
        f.print_average_score(stu_list);

        f.print_Info(stu_list);

    }
}
