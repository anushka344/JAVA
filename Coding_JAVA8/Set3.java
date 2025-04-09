// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

class Employee {
	String name;
	double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " = " + salary;
	}
}
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
// 		Given a list of integers, return the square of even numbers in sorted order.
List<Integer> li = Arrays.asList(4,6,5,4,3,2,1,1);
List<Integer> ans = li.stream().filter( x -> x%2==0).peek(System.out::println)
.map(x -> (x*x))
.sorted()
.collect(Collectors.toList());
System.out.println(ans);

// Find all duplicate elements in a list.
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = li.stream()
            .filter(i -> !seen.add(i))  // add returns false if already exists
            .collect(Collectors.toSet());
System.out.println(duplicates);

        // Find the first non-repeated character in a String using Java 
    String s ="anushka";
    Map<Character, Long> mp =s.chars() //instream of ascii
    .mapToObj(x -> (char)x) //converts to character
    .collect(Collectors.groupingBy(Function.identity(), 
    LinkedHashMap:: new,
    Collectors.counting()));
    
    System.out.println(mp);
  Optional<Character> op =  mp.entrySet().stream()
    .filter(x -> x.getValue()==1)
    .map(x -> x.getKey())
    .findFirst();
            System.out.println("First non-repeated character: " + op.orElse(null));

List<Employee> employees = Arrays.asList(
		                               new Employee("Alice", 60000),
		                               new Employee("Bob", 45000),
		                               new Employee("Charlie", 55000),
		                               new Employee("David", 50000),
		                                new Employee("David", 10000)
		                           );
		                           
		                           
Map<String, List<Employee>> ans2=   employees.stream()
		                           .collect(Collectors.groupingBy(
		                           (Employee   x)->x.name, Collectors.toList()));
		                           
		                           ans2.entrySet().		                           stream().map(x->x.getKey())  .forEach(System.out::println);;

        
    }
}
