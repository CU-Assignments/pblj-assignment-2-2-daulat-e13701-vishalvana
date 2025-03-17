import java.io.*;
// Serializable class
class Student implements Serializable {
 private static final long serialVersionUID = 1L;
 int id;
 String name;
 double gpa;
 public Student(int id, String name, double gpa) {
 this.id = id;
 this.name = name;
 this.gpa = gpa;
 }
 public void display() {
 System.out.println("ID: " + id + ", Name: " + name + ", GPA: " + gpa);
 }
}
public class StudentSerialization {
 private static final String FILE_NAME = "student.ser";
 // Serialize object
 public static void serializeStudent(Student student) {
 try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
 out.writeObject(student);
 System.out.println("Student object serialized.");
 } catch (IOException e) {
 e.printStackTrace();
}
}
// Deserialize object
public static Student deserializeStudent() {
try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
return (Student) in.readObject();
} catch (FileNotFoundException e) {
System.out.println("File not found.");
} catch (IOException | ClassNotFoundException e) {
e.printStackTrace();
}
return null;
}
public static void main(String[] args) {
Student student = new Student(101, "Alice", 3.8);
serializeStudent(student);
Student deserializedStudent = deserializeStudent();
if (deserializedStudent != null) {
System.out.println("Deserialized Student:");
deserializedStudent.display();
}
}
}
