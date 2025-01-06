package com.example.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {

    public static void main(String[] args) {

        //Create a list and filter all even no in list
        List<Integer> list1 = List.of(2,4,3,51,22,67); //list.of is immutable
        //list1.add(45);
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(31);
        list2.add(47);

        List<Integer> list3 = Arrays.asList(23,67,88,97); //immutable
        System.out.println(list1);

        //without stream -> boilerplate code
        List<Integer> listEven = new ArrayList<>();
        for(Integer i : list1)
        {
            if(i%2==0)
                listEven.add(i);
        }
        System.out.println(listEven);

        //using stream
//        Stream<Integer> stream = list1.stream();
//       List<Integer> newList =  stream.filter(i -> i%2==0).collect(Collectors.toList());
//        System.out.println(newList);

       List<Integer> newList =
               list1.stream().filter(i->i%2==0).collect(Collectors.toList());

        List<Integer> newList1 =
                list1.stream().filter(i->i>10).collect(Collectors.toList());


    }
}
