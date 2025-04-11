package week2;
import java.util.Scanner;
public class Fraction {

	public static void main(String[] args) {
		int numerator, denominator;
        double decimalEquivalent;
        // user to enter the denominator and numerator
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the numerator: ");
        numerator = scan.nextInt(); 
        System.out.print("Enter the denominator: ");
        denominator = scan.nextInt();
        // check if the denominator is zero to avoid division
        if (denominator == 0) {
            System.out.println("Error: Denominator cannot be zero.");
        } else {
            // calculate the decimal equivalent
            decimalEquivalent = (double) numerator / denominator;
            System.out.println("The decimal equivalent of the fraction is: " + decimalEquivalent);
        }

        scan.close();
    }
}