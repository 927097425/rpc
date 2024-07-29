package Train.Middian.Problem6;

import Train.Middian.Problem4.Methods;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        MyLinkedList mylist = new MyLinkedList();
        mylist.add();
        mylist.forEach(d-> System.out.println(d));
        Node head = mylist.getHead();
        System.out.println("--------------reverse-----------------");
        mylist.setHead(mylist.reverse(head,1,1));
        mylist.forEach(d-> System.out.println(d));

    }
}
