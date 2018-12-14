package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("b1",10));
        list.add(new Book("b2",50));
        list.add(new Book("b3",20));
        list.add(new Book("b4",80));
        list.add(new Book("b5",15));

        System.out.println("----排序前-----");
        list.stream().forEach(System.out::println);

        Collections.sort(list);

        System.out.println("----排序后-----");
        list.stream().forEach(System.out::println);
    }
}
