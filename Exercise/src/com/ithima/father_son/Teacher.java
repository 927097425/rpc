package com.ithima.father_son;

public class Teacher extends People{
    private String skill;
    @Override
    public String toString(){
        String result = "The information of teacher:\n"+"Name:"+getName()+"\nAge:"+getAge()+"\nSkill:"+skill;


        return result;
    }
    public static void said_word(){
        System.out.println("老师说你好");
    }

    public Teacher(){

    }
    public Teacher(String name,int age,String skill){
        super(name,age);
        this.skill = skill;
    }
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
