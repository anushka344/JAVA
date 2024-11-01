//Abstraction - Process of hiding the implementation details and showing only the necessary details.
/*
    In java , abstraction is achieved using abstract keyword and interfaces.

    Abstract class - are those classes which cannot be instantiated i.e. creation of objects of abstract class is not possible.
    Abstract methods-  are methods without any body.

    the class which will extend abstract class has to override the methods of abstract class. 

    abstract class can have noth abstarct and concrete methods
 */

public class Abstraction {
    public static void main(String[] args) {
      //not possible  Car c = new Car() ;
      BMW b = new BMW();
      b.start();

    }
}
class BMW extends Car{
    void start()
    {
        System.out.println("BMW is starting");
    }
}

abstract class Car{
    int price;
   abstract void start();
}
