package Train.Middian.Problem3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Searcher s = new Searcher();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入2022-02之后的月份");
            String Time_Input = sc.next();
            if(Time_Input.equals("-1")) break;
            s.Search(Time_Input);
        }
    }

}
