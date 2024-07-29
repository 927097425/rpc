package Train.Middian.Problem3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Searcher {
    private LocalDate target ;


    public void Search(String TimeMsg){
        String[] Time = TimeMsg.split("-");
        try {
            target = LocalDate.of(Integer.valueOf(Time[0]),Integer.valueOf(Time[1]),3);
            if(Time.length>2) target = target.withDayOfMonth(Integer.valueOf(Time[2]));
        } catch (Exception e) {
            System.out.println("输入格式有误，请重新输入");
            return;
        }

        LocalDate origin = LocalDate.of(2022,02,3);
        System.out.println(origin);
        if(target.isBefore(origin)) {
            System.out.println("您输入的信息有误，请输入2022年2月3日之后的日期");
            return;
        }
        System.out.println("输入有效");
        target = target.withDayOfMonth(1);
        LocalDateTime origin_ldt = LocalDateTime.of(origin, LocalTime.now());
        LocalDateTime target_ldt = LocalDateTime.of(target, LocalTime.now());

        int Month_pre = target_ldt.getMonth().getValue();
        for(int i = 0;target_ldt.getMonth().getValue() == Month_pre;i++){
            Long Gap_days = Duration.between(origin_ldt,target_ldt).toDays();
            System.out.print(target_ldt.getYear()+"-"+target_ldt.getMonth().getValue()+"-"+target_ldt.getDayOfMonth());
            if(Gap_days/3>=0&&Gap_days%3==0) {
                System.out.print("[休息]");
                int week_day = target_ldt.getDayOfWeek().getValue();
                if(week_day == 6) System.out.println("[星期六]");
                else if(week_day == 7) System.out.println("[星期天]");
                else System.out.println("");
            }
            else System.out.println("");
            target_ldt = target_ldt.plusDays(1);
        }

    }
}
