package Train.Middian.Problem2;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<User> users_list = new ArrayList<>();
        String userStrs = "10001:张三:男:1990-01-01#10002:扎根三:女:1989-01-09#10003:王五:男:1999-09-09#10004:刘备:男:1899-01-01#10005:孙悟空:男:1900-01-01#10006:张三:女:1999-01-01#10007:刘备:女:1999-01-01#10008:张三:女:2003-07-01#10009:猪八戒:男:1900-01-01";
        Pattern rule = Pattern.compile("1\\d{4,}:\\W{2,}:\\W{1}:\\d{4}-\\d{2}-\\d{2}");
        Matcher m = rule.matcher(userStrs);
        while (m.find()) {
            String[] strs = m.group().split(":");
            //for (int i = 0; i < strs.length; i++) System.out.println(strs[i]);
            users_list.add(new User(Long.valueOf(strs[0]),strs[1],strs[2], LocalDate.parse(strs[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }
        System.out.println(users_list);
        Map<String,Integer> name_times = new HashMap<>();
        for (int i = 0; i < users_list.size(); i++) {
            String key = users_list.get(i).getName();
            if(name_times.containsKey(key))name_times.put(key,name_times.get(key)+1);
            else name_times.put(key,1);
        }

        name_times.forEach((k,v)-> System.out.println(k+"------->"+v));



    }
}
