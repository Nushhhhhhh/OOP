package week8;

import java.util.Scanner;

public class Histogram {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] ranges = new int[10];
    System.out.println("Enter numbers between 1 and 100 (enter 0 to stop):");

    int number = scanner.nextInt();
    while (number != 0) {
        if (number >= 1 && number <= 100) {
            int index = (number - 1) / 10;
            ranges[index]++;
        } else {
            System.out.println("Invalid number. Please enter a number from 1 to 100.");
        }
        number = scanner.nextInt();
    }
    
    int start = 1;
    for (int i = 0; i < ranges.length; i++) {
        int end = start + 9;
        System.out.print(start + " - " + end + " | ");
        for (int j = 0; j < ranges[i]; j++) {
            System.out.print("*");
        }
        System.out.println();
        start = end + 1;
    }

    scanner.close();
}
}