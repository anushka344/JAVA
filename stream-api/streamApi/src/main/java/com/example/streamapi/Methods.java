package com.example.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Methods {
    public static void main(String[] args) {

        //filter  (takes predicate)
        //boolean valued func //fi;ter element based on predicate if it return true then select else ignore

            //map (function)
         //each element operation .. will return the value after performing some operation on it
        List<String> names = List.of("amj","hgg","anisdhfih","klklhjg");

        //check if starts with A.. that means boolean
        List<String> newnames =
                names.stream().filter(e -> (e.startsWith("a"))).collect(Collectors.toList());
        System.out.println(newnames);

        List<Integer> li = List.of(23,5,4,34,4);
        //square each no
        List<Integer> ansli=
        li.stream().map(e-> e*e).collect(Collectors.toList());
        System.out.println(ansli);

        //forEach method
        names.stream().forEach( e-> {
            System.out.println(e);
        });

        newnames.stream().forEach(System.out::println);

        //sort
        li.stream().sorted().forEach(System.out::println);

        //min
       int ans= li.stream().min((x,y)->x.compareTo(y)).get();
       System.out.println(ans);

       //max ->returns optional
        int maxi = li.stream().max((x,y)->x.compareTo(y)).get();
        System.out.println("Max"+maxi);
    }
}
