public class Interface implements walk,run{
  public  void walking(){
        System.out.println("walking");
    }
   public  void running(){
        System.out.println("running");
    }
    public static void main(String[] args) {
        Interface i = new Interface();
        i.walking();
    }
}
interface walk
{
    void walking(); //By default methods of interfaces are abstract and public
}
interface run{
    void running();
}