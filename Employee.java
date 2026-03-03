
import java.util.Scanner;


class Employee {
    String name , department ;
    int age,id ,salary;
    public static void main(String[] args) {
         
    
    Scanner myobj =  new Scanner (System.in);
    System.out.println("enter the details");
    System.out.println("enter the name");
    String name = myobj.nextLine();
    System.out.println("enter the department");
    String department = myobj.nextLine();
    System.out.println("enter the age");
    int age=myobj.nextInt();
    System.out.println("enter the id");
    int id=myobj.nextInt();
    System.out.println("enter the salary");
    int salary=myobj.nextInt();


    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Department: " + department);
    System.out.println("ID: " + id);
    System.out.println("Salary: " + salary);
    
    


        
    }
   
    


    
}
