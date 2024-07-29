package com.ithima.doudizhu;

import com.ithima.demo.A;

import java.util.*;

public class Room {
    private List<Card> Cards =  new ArrayList<>();

    public Room(){
        String []  Numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String []  Colars = {"♦","♣","♥","♠"};

        int size = 0;
        for(String n :Numbers){
            for(String c:Colars){
                size++;
                Cards.add(new Card(n,c,size));
            }
        }
        Cards.add(new Card("sking","🃏",++size));
        Cards.add(new Card("bking","🃏",++size));
        System.out.println("洗牌前："+Cards);

    }

    public void start(){
        Collections.shuffle(Cards);
        System.out.println("洗牌后："+Cards);

        List<Card> Player1 = new ArrayList<>();
        List<Card> Player2 = new ArrayList<>();
        List<Card> Player3 = new ArrayList<>();


        for(int i = 0;i<Cards.size()-3;i++)
        {
            if(i%3==0) Player1.add(Cards.get(i));
            else if(i%3 ==1) Player2.add(Cards.get(i));
            else Player3.add(Cards.get(i));
        }
        List<Card> Last_Cards = Cards.subList(Cards.size()-3,Cards.size());
        sortCards(Player1);
        sortCards(Player2);
        sortCards(Player3);
        System.out.println(Player1);
        System.out.println(Player2);
        System.out.println(Player3);
        //叫地主
        Map<String,Integer > map = new HashMap<>();

        Player3.addAll(Last_Cards);
        sortCards(Player3);
        System.out.println(Player3);


    }
    public void sortCards(List<Card> Cards){
        Collections.sort(Cards, (o1,  o2) -> o2.getSize()- o1.getSize());//降序排列
    }

}
