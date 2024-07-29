package com.ithima.date_demo;


import java.text.*;
import java.util.Date;

public class KIll {
    public static void main(String [] args) throws ParseException {
        SimpleDateFormat dfm = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String start_time =  "2023年11月11日 00:00:00";
        String end_time =  "2023年11月11日 00:10:00";
        String User1 = "2023年11月11日 00:01:18";
        String User2 = "2023年11月11日 00:10:51";

        Date _start = dfm.parse(start_time);
        Date _end = dfm.parse(end_time);
        Date U1 = dfm.parse(User1);
        Date U2 = dfm.parse(User2);


        Long _start_mills = _start.getTime();
        Long _end_mills = _end.getTime();
        Long U1_milis = U1.getTime();
        Long U2_milis = U2.getTime();

        if(U1_milis>=_start_mills&&U1_milis<=_end_mills) System.out.println("U1秒杀成功");
        else System.out.println("U1秒杀失败");
        if(U2_milis>=_start_mills&&U2_milis<=_end_mills) System.out.println("U2秒杀成功");
        else System.out.println("U2秒杀失败");

    }
}
