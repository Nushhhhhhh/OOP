package week2;
import java.util.Scanner;
public class SquareCalculation {

	public static void main(String[] args) {
		int length, perimeter, area;

        //get user input
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the length of the square's side: ");
        length = obj.nextInt(); 

        // Calculate perimeter and area
        perimeter = 4 * length; 
        area = length * length; 

        // Print the results
        System.out.println("The perimeter of the square is: " + perimeter);
        System.out.println("The area of the square is: " + area);

        // Close the scanner
        obj.close();
    }
}