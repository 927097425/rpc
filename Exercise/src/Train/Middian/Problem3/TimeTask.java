package Train.Middian.Problem3;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
    // 高考开始时间
    private LocalDateTime startTime;

    // 构造器，对高考的开始时间进行初始化
    public TimeTask() {
        String s = "2024-06-07 09:00:00";
        String[] Date_Time = s.split(" ");
        String[] Date = Date_Time[0].split("-");
        String[] Time = Date_Time[1].split(":");
        startTime = LocalDateTime.of(Integer.valueOf(Date[0]),Integer.valueOf(Date[1]),Integer.valueOf(Date[2]),Integer.valueOf(Time[0]),Integer.valueOf(Time[1]),Integer.valueOf(Time[2]));

    }

    // 每一秒执行一次该方法
    @Override
    public void run() {
        LocalDateTime Time_now = LocalDateTime.now();
        Long Gap = Duration.between(Time_now,startTime).toSeconds();

        Long Seconds =  Gap%60;
        Long Minutes = (Gap/60)%60;
        Long Hours = (Gap/3600)%24;
        Long Days = (Gap/3600)/24;
        System.out.println("距离高考还有："+Days+"天"+Hours +"时"+Minutes+"分"+Seconds+"秒");

    }

}
