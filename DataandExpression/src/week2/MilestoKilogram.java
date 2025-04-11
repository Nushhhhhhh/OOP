package week2;
import java.util.Scanner;
public class MilestoKilogram {

	public static void main(String[] args) {
        double miles, kilometers;
        final double amile = 1.60935; // 1 mile = 1.60935 km
        
        // get user input
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the distance in miles: ");
        miles = obj.nextDouble();

        //convert miles to kilometers
        kilometers = miles * amile;

        //print the result
        System.out.println(miles + " miles is equal to " + kilometers + " kilometers.");

        obj.close();
    }
}