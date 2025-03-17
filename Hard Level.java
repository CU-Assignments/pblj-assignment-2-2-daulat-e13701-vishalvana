import java.io.*;
import java.util.*;
class Employee implements Serializable {
 private static final long serialVersionUID = 1L;
 int id;
 String name, designation;
 double salary;
 public Employee(int id, String name, String designation, double salary) {
    this.id = id;
 this.name = name;
 this.designation = designation;
 this.salary = salary;
 }
 @Override
 public String toString() {
 return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
 }
}
public class EmployeeManagement {
 private static final String FILE_NAME = "employees.dat";

 // Add employee to file
 public static void addEmployee(Employee emp) {
 List<Employee> employees = loadEmployees();
 employees.add(emp);
 saveEmployees(employees);
 System.out.println("Employee added successfully.");
 }
 // Display all employees
 public static void displayEmployees() {
 List<Employee> employees = loadEmployees();
 if (employees.isEmpty()) {
 System.out.println("No employees found.");
 return;
 }
 for (Employee emp : employees) {
 System.out.println(emp);
}
}
// Save employee list to file
private static void saveEmployees(List<Employee> employees) {
try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
out.writeObject(employees);
} catch (IOException e) {
e.printStackTrace();
}
}
// Load employee list from file
@SuppressWarnings("unchecked")
private static List<Employee> loadEmployees() {
try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
return (List<Employee>) in.readObject();
} catch (FileNotFoundException e) {
return new ArrayList<>(); // Return empty list if file does not exist
} catch (IOException | ClassNotFoundException e) {
e.printStackTrace();
return new ArrayList<>();
}
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int choice;
while (true) {
System.out.println("\n1. Add Employee\n2. Display All Employees\n3. Exit");
System.out.print("Enter choice: ");
choice = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 switch (choice) {
 case 1:
 System.out.print("Enter Employee ID: ");
 int id = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 System.out.print("Enter Name: ");
 String name = scanner.nextLine();
 System.out.print("Enter Designation: ");
 String designation = scanner.nextLine();
 System.out.print("Enter Salary: ");
 double salary = scanner.nextDouble();
 addEmployee(new Employee(id, name, designation, salary));
 break;
 case 2:
 displayEmployees();
 break;
 case 3:
 System.out.println("Exiting program.");
 scanner.close();
 return;
 default:
 System.out.println("Invalid choice. Try again.");
 }
 }
 }
}
