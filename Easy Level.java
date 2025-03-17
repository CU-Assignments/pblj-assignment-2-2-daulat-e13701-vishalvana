import java.util.*;
public class AutoboxingExample {
 public static int calculateSum(List<Integer> numbers) {
 int sum = 0;
 for (int num : numbers) { // Unboxing happens here
 sum += num;
 }
 return sum;
 }
 public static void main(String[] args) {
 List<Integer> numbers = new ArrayList<>();
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter numbers separated by space: ");
 String[] inputs = scanner.nextLine().split(" ");

 for (String input : inputs) {
 numbers.add(Integer.parseInt(input)); // Autoboxing from int to Integer
 }

 System.out.println("Sum of numbers: " + calculateSum(numbers));
 scanner.close();
 }
}
