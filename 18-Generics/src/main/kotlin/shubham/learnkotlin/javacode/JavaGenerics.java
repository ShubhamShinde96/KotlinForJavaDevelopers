package shubham.learnkotlin.javacode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello");

//        boolean b = list instanceof List<String>; as in this line we're getting compiletime error to "List<String> because at runtime JVM cannot
        // be able to determine if list is instanceOf List<"String">

        // so here java can figure out if list is instanceOf List, like below
        boolean b = list instanceof List;

        //in kotlin we'll try to do same using "is" operator same as in java we use "instanceOf"

//        list.add(new BigDecimal(10.2));
        list.get(0).toUpperCase();

        List list1 = new ArrayList<>();
        list1.add("GoodBye");
        list1.add(new BigDecimal(10.2));

    }

}
