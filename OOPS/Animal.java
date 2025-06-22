public class Animal {
   public String name;
    public int age;
    static int count=2; //If a variable is declared as static we need not require to create an object. 
    //we can access it by className.variableName
   public void walk()
    {
        System.out.println("I am walking");
    }
    void walk(int i)
    {
        this.age =i;
        count++;
        System.out.println("I am walking"+i+"steps");
    }
    public Animal()
    {
        System.out.println("def constructor");
    }
   }