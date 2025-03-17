import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class Main {
	public static void   findEmpWithHighestSalary(List<Employee> employees)
	{
		Employee ans = employees.stream()
		               .max(Comparator.comparingDouble(emp -> emp.salary)).orElse(null); // Find the max salary
		//   .ifPresent(emp -> System.out.println("Employee with highest salary: " + emp));
		System.out.println(ans);
	}
	public static void   findPartition(List<Employee> employees) {
		Map<Boolean, List<Employee>> ans=
		    employees.stream().collect(Collectors.partitioningBy( x -> x.salary>50000));
		System.out.println("Employees with salary > 50000: " + ans.get(true));
		System.out.println("Employees with salary <= 50000: " + ans.get(false));
	}
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
		                               new Employee("Alice", 60000),
		                               new Employee("Bob", 45000),
		                               new Employee("Charlie", 55000),
		                               new Employee("David", 50000)
		                           );
		findPartition(employees);
		findEmpWithHighestSalary(employees);
	}
}