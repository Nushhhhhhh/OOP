package week4;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Deli {
    public static void main(String[] args) {
        final double OUNCES_PER_POUND = 16.0;

        double pricePerPound;   
        double weightOunces;    
        double weight;            
        double totalPrice;      

        Scanner scan = new Scanner(System.in);

        NumberFormat money = NumberFormat.getCurrencyInstance();

        DecimalFormat fmt = new DecimalFormat("0.00");

        System.out.println("Welcome to the CS Deli!!\n");

        System.out.print("Enter the price per pound of your item: ");
        pricePerPound = scan.nextDouble();

        System.out.print("Enter the weight (ounces): ");
        weightOunces = scan.nextDouble();

        weight = weightOunces / OUNCES_PER_POUND;
        totalPrice = pricePerPound * weight;

        System.out.println("\n     *****  CS Deli  *****\n");
        System.out.println("     Unit Price: " + money.format(pricePerPound) + " per pound");
        System.out.println("     Weight: " + fmt.format(weight) + " pounds\n");
        System.out.println("     TOTAL:  " + money.format(totalPrice));

        scan.close();
    }
}
