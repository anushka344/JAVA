class Student {
 public String name;
 public int age;

 public void getCheck()
 {
    System.out.println("Calling method");
 }
 // Default Constructor
//  A no-argument constructor automatically provided by the Java compiler if no other constructor is defined.
// It initializes the object with default values (e.g., null for objects, 0 for integers, etc.).

// public Student()
// {
//     System.out.println("Default Cpnstructor called");
// }

// No-Argument Constructor
// A no-argument constructor is explicitly defined by the programmer without any parameters.
// Commonly used for initializing default values.
public Student() {
    this.name = "Unknown";
    this.age = 18;
}
// Parameterized Constructor
// A constructor that takes one or more parameters.
public Student(String name, int age) {
    this.name = name;
    this.age = age;
}
// Copy Constructor
// A constructor that takes an object of the same class as a parameter.
// It creates a new object by copying values from an existing object.

    // Copy Constructor
    public Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }



}

public class ConstructorMain {
    public static void main(String[] args) {
        Student s = new Student();
        s.getCheck();
        System.out.println(s.age);
        s.age=12;
        s.name="anu";
        Student s2 = new Student(s);
        System.out.println(s2.name);

    }
}



