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
      private int totalThread;
      private int threadid;
    public Printer(SharedResource sharedResource,int totalThread,
    int threadid) {
        this.sharedResource = sharedResource;
        this.totalThread=totalThread;
        this.threadid =  threadid;
    }
    @Override
    public void run() {
        while(true)
        {
            synchronized(sharedResource)
            {
                while((sharedResource.getCounter()-1) %totalThread != threadid && sharedResource.getCounter() <= sharedResource.getMaxValue()) {
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
         SharedResource sharedResource = new SharedResource(16);
       // System.out.println("Try programiz.pro");
       int totalThreads=3;
       for(int i=0;i<totalThreads;i++)
       {
        Thread thread= new Thread(new Printer(sharedResource,totalThreads,i), "Thread - "+i);
        thread.start();
       }
       
    }
}