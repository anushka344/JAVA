package com.example.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {

        //Stream API - Collection process and also to process grp of objects
        //1. create blank stream
        Stream<Object> emptyStream = Stream.empty();

        //2. taking an array and converting to steam object
        String[] names = {"Anbbj" , "juh" ,"hgh"};

        Stream<String> stream1 = Stream.of(names);
        stream1.forEach( e-> {
            System.out.println(e);
        });

        //3. Stream builder patstern
        Stream<Object> streamBuilder = Stream.builder().build();

        //4
        IntStream stream = Arrays.stream(new int[]{8,9,76});

        //5. list,set
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(31);
        list2.add(47);
        Stream<Integer> stream3 = list2.stream();
        stream3.forEach(e->{
            System.out.println(e);
        });
    }
}
