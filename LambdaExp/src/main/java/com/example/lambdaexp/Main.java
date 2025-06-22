package com.example.lambdaexp;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
//        MyInterfaceImpl m= new MyInterfaceImpl();
//        m.sayHello();

        //I am not making obj of inetrafce which is imposssible.. here i am maing obj of child class of interface
      /*  MyInterface i = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Object of child class of interface : Anonymous class1");
            }
        };
        i.sayHello();

        MyInterface i2 =new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("Anonymoud class2");
            }
        };
        i2.sayHello(); */

        //Using our interface with help of Lambda
        MyInterface i = ()->
            System.out.println("Lamda Impl");

        i.sayHello();

        MyInterface i2 = () -> {  System.out.println("Lamda Impl 2nd time"); };
        i2.sayHello();

        SumInter s1 = (int a,int b) ->  (a+b);
        System.out.println( s1.sum(1,2));

        LengthInter li = (str -> str.length());
        System.out.println("Length of string: "+ li.getLength("Anushka"));
    }
}
