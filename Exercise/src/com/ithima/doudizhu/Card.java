package com.ithima.doudizhu;

public class Card {
    private String number;
    private String  colar;
    private int size;

    public Card(){

    }
    public Card(String number,String colar,int size){
        this.number = number;
        this.colar = colar;
        this.size = size;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColar() {
        return colar;
    }

    public void setColar(String colar) {
        this.colar = colar;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return this.getColar()+this.getNumber();
    }
}
