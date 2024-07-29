package Day12_homework;

import java.util.LinkedList;

public class Gift_BOX {
    private int gift_num = 1000000;
    private  int count = 0;
    public synchronized void sent(){
        if(gift_num>0) {
            count++;
            gift_num = gift_num-1;
            System.out.println(Thread.currentThread().getName() + "送出了第" + (1000000 - gift_num ) + "份礼物" + "还有" + gift_num + "份礼物");

        }
    }

    public int getGift_num() {
        return gift_num;
    }

    public void setGift_num(int gift_num) {
        this.gift_num = gift_num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
