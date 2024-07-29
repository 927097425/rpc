package com.ithima.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test {
    public static void main(String [] args) throws ParseException {
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 a EEE");

        String d_sdf = sdf.format(d);
        System.out.println(d_sdf);

        Date d2 = sdf.parse(d_sdf);
        System.out.println(d2);
    }
}
