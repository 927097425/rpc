package Train.Middian.Problem6;

import java.util.Scanner;

public class MyLinkedList {
    private Node head = null;
    public Node add(){
        System.out.println("如要退出请输入exit，请输入数据：");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String text = sc.next();
            if(!isLegal(text)){
                System.out.println("您输入有误，如要退出请输入exit，如要输入数据请继续：");
                continue;
            }
            if(text.equalsIgnoreCase("exit")) return head;
            else {
                Node  newNode = new Node(Integer.valueOf(text),null);
                if(head == null) head = newNode;
                else {
                    Node temp = head;
                    while (temp.getNext() != null) temp = temp.getNext();
                    temp.setNext(newNode);
                }
                System.out.println("添加成功");
            }

        }
    }

    public void forEach(ForEach f){
        Node temp = head;
        while(temp!=null) {
            f.func(temp);
            temp = temp.getNext();
        }
    }

    public  Node reverse(Node head,int left,int right){
        if(head == null)  return null;
        Node virtrul_head = new Node(0,head);
        Node temp = head;
        Node help_head = null;
        Node pre = virtrul_head;//记录截断的前一个节点
        Node end  = null;//记录截断的后一个节点
        int count =1;
        while(temp!=null){
            if(count++ == left) {
                help_head = temp;
            }
            if(count == right+1) {
                end = temp.getNext();
                temp.setNext(null);
                break;
            }
            if(count<=left) pre = pre.getNext();
            temp = temp.getNext();
        }
        pre.setNext(reverse_help(help_head,end));
        return virtrul_head.getNext();
    }
    private Node reverse_help(Node head,Node end){
        Node pre = null;
        Node cur = head;
        while(cur!=null){
            Node temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
        }
        head.setNext(end);
        return pre;
    }

    private boolean isLegal(String text){
        if(text.equalsIgnoreCase("exit")||text.matches("[0-9]{1,}")) return true;
        else return false;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head){
        this.head = head;
    }

}
