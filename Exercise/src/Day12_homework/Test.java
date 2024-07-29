package Day12_homework;

public class Test {
    public static void main(String[] args) throws Exception {
        Gift_BOX gift = new Gift_BOX();
        Thread t1 = new Thread(() -> {while(gift.getGift_num()>0)gift.sent();},"小红");
        Thread t2 = new Thread(() -> {while(gift.getGift_num()>0)gift.sent();},"小明");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(gift.getCount());

    }
}
