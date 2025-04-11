package week2;
import java.util.Scanner;
public class Average {

	public static void main(String[] args) {
		int val1, val2, val3;
        double average;
        Scanner scan = new Scanner(System.in);

        // get user input
        System.out.println("Please enter three integers and " + "I will compute their average");
        System.out.print("Enter first value: ");
        val1 = scan.nextInt();
        System.out.print("Enter second value: ");
        val2 = scan.nextInt();       
        System.out.print("Enter third value: ");
        val3 = scan.nextInt(); 

        // calculate the average
        average = (val1 + val2 + val3) / 3.0; 

        // print the average
        System.out.println("The average of the three value is " + average); 
        
        scan.close(); 
    }
}