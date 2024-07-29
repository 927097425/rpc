package Train.Final.Problem6;

public class MyLinkedList<E extends Comparable> {
    // 封装一个链表
    Node<E> head = null;
    /**
     * 定义了一个私有的内部类，作为链表的结点。
     */
    public static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node<E> add(E e) {
        if (head == null) {
            head = new Node(e, null);
        } else {
            // 往后面插入结点。（尾插法）
            Node<E> temp = head;
            // 让temp走到尾部结点
            while (temp.next != null) {
                temp = temp.next;
            }
            // 把当前结点创建出来，加入到尾部结点
            temp.next = new Node(e, null);
        }
        return head;


    }

    public void sort(){
        Node<E> pre = head;
        Node<E> cur = head.next;
        if(cur ==null) return;
        while(cur!=null&&pre!=null){
            if(cur.data.compareTo(pre.data)<0){
                E temp = cur.data;
                cur.data = pre.data;
                pre.data = temp;
            }

            cur = cur.next;
            if(cur == null){
                pre = pre.next;
                if(pre!=null)cur = pre.next;
            }
        }
    }

    public void print(){
        Node<E> temp = head;
        if(temp==null) {
            System.out.println("null");
            return;
        }
        System.out.print(temp.data);
        while(temp.next!=null){
            temp = temp.next;
            System.out.print("->");
            System.out.print(temp.data);
        }
        System.out.println("");
    }
    public MyLinkedList<E> mergesort(MyLinkedList list2){
        MyLinkedList<E> newlist = new MyLinkedList<>();
        this.sort();
        list2.sort();
        Node<E> cur1 = this.head;
        Node<E> cur2 = list2.head;
        while(cur1!=null&&cur2!=null){
            if(cur1.data.compareTo(cur2.data)<0){
                newlist.add(cur1.data);
                cur1 = cur1.next;
            }else{
                newlist.add(cur2.data);
                cur2 = cur2.next;
            }
        }
        while(cur1!=null) {
            newlist.add(cur1.data);
            cur1 = cur1.next;
        }
        while(cur2!=null){
            newlist.add(cur2.data);
            cur2 = cur2.next;
        }


        return newlist;

    }
}