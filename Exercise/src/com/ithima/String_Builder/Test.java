package com.ithima.String_Builder;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        double [] numbers= new double[]{0.1,0.2,0.3,0.4,0.5,0.6};
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < numbers.length; i++) {
            BigDecimal number = BigDecimal.valueOf(numbers[i]);
            sum = sum.add(number);
        }
        System.out.println(sum);
        double sum_d = sum.doubleValue();
        System.out.println(sum_d);
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0;i<numbers.length;i++)
        {
            str.append(numbers[i]);
            if(i!=numbers.length-1)str.append(",");
        }

        str.append("]");
        System.out.println(str);
    }

}
