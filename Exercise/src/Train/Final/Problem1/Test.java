package Train.Final.Problem1;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();
        LocalDateTime today = LocalDateTime.parse("2023-05-16T20:55:10");
        Document doc = saxReader.read("src\\Train\\Final\\Problem1\\orders.xml");
        Element docroot = doc.getRootElement();
        List<Order> Orders = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for(Element order :docroot.elements()){
            Order temp = new Order();
            temp.setId(order.attributeValue("id"));
            temp.setName(order.elementText("name"));
            temp.setPrices(Double.valueOf(order.elementText("double")));
            temp.setOrderedTime(LocalDateTime.parse(order.elementText("time"),dtf));
            Orders.add(temp);
        }
        Orders.stream().filter(o->o.getOrderedTime().isBefore(today)).forEach(o-> System.out.println(o));
        Orders.stream().sorted((o1, o2) -> o2.getPrices().compareTo(o1.getPrices())).limit(1).forEach(
                o->{
                    System.out.println(o);
                }
        );



    }
}
