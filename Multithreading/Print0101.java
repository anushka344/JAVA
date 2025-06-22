// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
 class  SharedResource {
     private int counter=1;
     private int MAX_VALUE;
     public SharedResource(int MAX_VALUE) {
         this.MAX_VALUE = MAX_VALUE;
     }
     public int getCounter()
     {
         return this.counter;
     }
     public int getMaxValue()
     {
         return this.MAX_VALUE;
     }
     public void setCounter(int counter) {
         this.counter= counter;
     }
     public void increment()
     {
        //  System.out.printf("%d is printed by %s \n",counter, Thread.currentThread().getName());
         counter++;
     }
}
 class PrintOne implements Runnable {
      private SharedResource sharedResource;
    public PrintOne(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        while(true)
        {
            synchronized(sharedResource)
            {
                if(sharedResource.getCounter() %2 !=0 && sharedResource.getCounter() <= sharedResource.getMaxValue()) {
                    try {
                        sharedResource.wait();
                    }
                    catch(InterruptedException e){
                       throw new RuntimeException(e);
                    }
                }
                if(sharedResource.getCounter() > sharedResource.getMaxValue())
                {
                    sharedResource.notifyAll();
                    break;
                }
                 System.out.printf("1");
                 sharedResource.increment();
                sharedResource.notifyAll();
            }
            
        }
    }
}

class PrintZero implements Runnable {
    private SharedResource sharedResource;
    public PrintZero(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        while(true)
        {
            synchronized(sharedResource)
            {
                if(sharedResource.getCounter() %2 ==0 && sharedResource.getCounter() <= sharedResource.getMaxValue()) {
                    try {
                        sharedResource.wait();
                    }
                    catch(InterruptedException e){
                       throw new RuntimeException(e);
                    }
                }
                if(sharedResource.getCounter() > sharedResource.getMaxValue())
                {
                    sharedResource.notifyAll();
                    break;
                }
                System.out.printf("0");
                    sharedResource.increment();
                sharedResource.notifyAll();
            }
            
        }
    }
}

public class Main  {
   
    public static void main(String[] args) {
         SharedResource sharedResource = new SharedResource(10);
       // System.out.println("Try programiz.pro");
        Thread t1 = new Thread(new PrintZero(sharedResource), "Odd");
        Thread t2= new Thread(new PrintOne(sharedResource), "Even");
        t1.start();
        t2.start();
    }
}