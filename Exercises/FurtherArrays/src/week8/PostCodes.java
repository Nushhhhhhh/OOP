package week8;

import java.util.Scanner;

public class PostCodes {

    // Class to store a person's details
    static class Person {
        String firstName;
        String lastName;
        String postCode;

        Person(String firstName, String lastName, String postCode) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.postCode = postCode;
        }

        void display() {
            System.out.println(firstName + " " + lastName + " - " + postCode);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person[] people = new Person[25];
        int count = 0;

        // Ask for user input
        System.out.println("Enter names and postcodes (first name last name postcode). Enter 'exit' to finish.");

        while (count < 25) {
            System.out.print("Entry " + (count + 1) + ": ");
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("exit")) break;

            // Split input by space
            String[] parts = line.split(" ");

            if (parts.length == 3) {
                people[count++] = new Person(parts[0], parts[1], parts[2]);
            } else {
                System.out.println("Please enter exactly 3 values.");
            }
        }

        // Print all entered data
        System.out.println("\n--- List of People and Postcodes ---");
        for (int i = 0; i < count; i++) {
            people[i].display();
        }

        scanner.close();
    }
}

