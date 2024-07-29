package Train.Middian.Problem4;

import java.util.Objects;

public class MyArrayList<T> implements Methods<T>{
//    1、MyArrayList需要支持泛型，内部使用数组作为容器。
//
//    2、在MyArrayList中开发add方法，用于添加数据的，需要遵循ArrayList的扩容机制（自行设计代码，不需要与ArrayList的源代码一样，思想一致即可）
//
//    3、在MyArrayList中开发根据索引查询数据的get方法。
//
//    4、在MyArrayList中开发根据索引删除数据的remove方法。
//
//    5、在MyArrayList中开发一个获取集合大小的size ()方法。
//
//    6、能够在MyArrayList集合中开发一个forEach方法，这个方法支持使用Lambda进行遍历，至于函数式接口叫什么名称无所谓。
//
//    7、编写测试用例对自己编写的MyArrayList集合进行功能正确性测试。
    private int size = 10;
    private int capacity = 0;
    private Object[] MyArray;

    MyArrayList(){
        MyArray = new Object[10];
    }

    @Override
    public void add(T elem) {
        if(capacity!=size) MyArray[capacity] = elem;
        else{
            size *=2;
            Object[] new_List = new Object[size];
            add_all(new_List,MyArray);
            MyArray = new_List;
            MyArray[capacity] = elem;
        }
        capacity++;
    }

    @Override
    public T get(int index) {
        return (T)MyArray[index];
    }

    @Override
    public void remove(int index) {
        for (int i = index+1; i < capacity; i++)MyArray[i-1] = MyArray[i];
        capacity--;
    }

    @Override
    public int getSize() {
        return capacity;
    }

    @Override
    public void forEach(ForEach<T> f) {
        for (int i = 0; i < capacity; i++) {
            f.accpet((T)MyArray[i]);
        }

    }


    private void add_all(Object[] new_list,Object[] old_list){
        for (int i = 0; i < old_list.length; i++) {
            new_list[i] = old_list[i];
        }
    }

}
