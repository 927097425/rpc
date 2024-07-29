package Train.Middian.Problem4;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> my_list = new MyArrayList<Integer>();
        my_list.add(5);
        my_list.add(4);
        my_list.add(3);
        my_list.add(2);
        my_list.add(1);
        my_list.add(5);
        my_list.add(4);
        my_list.add(3);
        my_list.add(2);
        my_list.add(1);
        my_list.add(5);
        my_list.add(4);
        my_list.add(3);
        my_list.add(2);
        my_list.add(1);
        System.out.println(my_list.getSize());
        my_list.forEach(elem-> System.out.print(elem+" "));
        System.out.println("");
        my_list.remove(6);
        System.out.println(my_list.getSize());
        my_list.forEach(elem-> System.out.print(elem+" "));
        my_list.forEach(new ForEach<Integer>() {
            @Override
            public void accpet(Integer list_myArray) {

            }
        });


    }


}
