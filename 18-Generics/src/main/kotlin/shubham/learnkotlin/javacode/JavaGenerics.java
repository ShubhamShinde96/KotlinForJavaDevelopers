package shubham.learnkotlin.javacode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello");
//        list.add(new BigDecimal(10.2));
        list.get(0).toUpperCase();

        List list1 = new ArrayList<>();
        list1.add("GoodBye");
        list1.add(new BigDecimal(10.2));

    }

}
