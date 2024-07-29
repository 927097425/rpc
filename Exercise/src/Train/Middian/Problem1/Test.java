package Train.Middian.Problem1;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Prison p1 = new Prison();
        System.out.println(p1);
        while(p1.getP().size()>1) {
            p1.excution();
            System.out.println("--------------Excution-----------------");
            p1.getP().forEach(s -> System.out.println(s));

        }

        System.out.println("Lucky boy is "+p1.getP().get(0).getCode_number());

    }
}
