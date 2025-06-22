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
     public void print()
     {
         System.out.printf("%d is printed by %s \n",counter, Thread.currentThread().getName());
         counter++;
     }
}
 class Printer implements Runnable {
      private SharedResource sharedResource;
      private int isOddEven;
    public Printer(SharedResource sharedResource, int isOddEven) {
        this.sharedResource = sharedResource;
        this.isOddEven=isOddEven;
    }
    @Override
    public void run() {
        while(true)
        {
            synchronized(sharedResource)
            {
                if(sharedResource.getCounter()-1 %2 != isOddEven && sharedResource.getCounter() <= sharedResource.getMaxValue()) {
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
                sharedResource.print();
                sharedResource.notifyAll();
            }
            
        }
    }
}


public class Main  {
   
    public static void main(String[] args) {
         SharedResource sharedResource = new SharedResource(10);
       // System.out.println("Try programiz.pro");
        Thread t1 = new Thread(new Printer(sharedResource,0), "Odd");
        Thread t2= new Thread(new Printer(sharedResource,1), "Even");
        t1.start();
        t2.start();
    }
}