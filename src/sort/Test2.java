package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Food> list = new ArrayList<>();
        list.add(new Food("f1",50));
        list.add(new Food("f2",10));
        list.add(new Food("f3",30));
        list.add(new Food("f4",20));
        list.add(new Food("f5",5));

        System.out.println("----排序前-----");
        list.stream().forEach(System.out::println);

        //最原始的做法，通过实现Comparator接口实现排序
        list.sort(new FoodComparator());

        //这种写法本质上没有问题，但是List接口中提供了默认的sort(Comparator<? super E> c)
        /*Collections.sort(list,(f1,f2)->
            (int)(f1.getPrice() - f2.getPrice())
        );*/

        //通过List接口的默认方法sort(Comparator<? super E> c)实现排序
        /*list.sort((f1,f2)->
                (int)(f1.getPrice() - f2.getPrice())
        );*/

        System.out.println("----排序后-----");
        list.stream().forEach(System.out::println);

    }
}
