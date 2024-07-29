package Train.Final.Problem2;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String text =  "张全蛋儿  农家乐,野外拓展\n" +
                "李二狗子  轰趴,野外拓展,健身房\n" +
                "翠花     野外拓展\n" +
                "小帅     轰趴，健身房\n" +
                "有容     农家乐";
        List<Person> groups = new ArrayList<>();
        String[] users = text.split("\n");
        Map<String,Integer> chose_count = new HashMap<>();
        for(String u: users){
            Person p = new Person();
            String[] Text = u.split("\\s{1,}");
            p.setName(Text[0]);
            for (String choses:Text[1].split(","))p.AddChose(choses);
            groups.add(p);
        }
        groups.stream().forEach(o->{
            for(String c:o.getChose()){
                if (chose_count.get(c)==null) chose_count.put(c,1);
                else chose_count.put(c,chose_count.get(c)+1);
            }
        });
        System.out.println(chose_count);
        Set<Map.Entry<String, Integer>> choses  =  chose_count.entrySet();
        String Max_chose = choses.stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get().getKey();
        System.out.println(Max_chose);

        groups.stream().filter(p->{
            List<String> chose = p.getChose();
            Long number = chose.stream().filter(c->c.contains(Max_chose)).count();
            return number<=0;
        }).forEach(p-> System.out.println(p.getName()));


    }
}
