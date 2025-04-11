package week8;

import java.util.Scanner;

public class LLBankAccount {

    static class BankAccount {
        String name;
        double balance;

        BankAccount(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        void deposit(double amount) {
            if (amount > 0)
                balance += amount;
            else
                System.out.println("Amount must be positive.");
        }

        void withdraw(double amount) {
            if (amount > balance)
                System.out.println("Not enough balance.");
            else if (amount <= 0)
                System.out.println("Amount must be positive.");
            else
                balance -= amount;
        }

        void addInterest() {
            balance += balance * 0.03;
        }

        void show() {
            System.out.println(name + " - Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        Scanner newscan = new Scanner(System.in);
        BankAccount[] accs = new BankAccount[30];
        int count = 0;

        while (true) {
            System.out.println("\n1. Create\n2. Deposit\n3. Withdraw\n4. Interest\n5. Show All\n6. Exit");
            System.out.print("\nChoose: ");
            int choice = newscan.nextInt();
            newscan.nextLine(); // clear buffer
            //create account
            if (choice == 1 && count < 30) {
                System.out.print("Name: ");
                String name = newscan.nextLine();
                System.out.print("Deposit: ");
                double dep = newscan.nextDouble();
                accs[count++] = new BankAccount(name, Math.max(dep, 0));
            } 
            //Deposit
            else if (choice == 2) {
                System.out.print("Name: ");
                String name = newscan.nextLine();
                BankAccount acc = find(accs, count, name);
                if (acc != null) {
                    System.out.print("Deposit amount: ");
                    double amt = newscan.nextDouble();
                    acc.deposit(amt);
                } else {
                    System.out.println("Account not found.");
                }
            } 
         // Withdraw
            else if (choice == 3) {
                System.out.print("Name: ");
                String name = newscan.nextLine();
                BankAccount acc = find(accs, count, name);
                if (acc != null) {
                    System.out.print("Withdraw amount: ");
                    double amt = newscan.nextDouble();
                    acc.withdraw(amt);
                } else {
                    System.out.println("Account not found.");
                }
            }
            //Add intrest
            else if (choice == 4) {
                for (int i = 0; i < count; i++)
                    accs[i].addInterest();
                System.out.println("Interest added.");
            } 
            //Show all account
            else if (choice == 5) {
                for (int i = 0; i < count; i++)
                    accs[i].show();
            //Exit
            } else if (choice == 6) {
                System.out.println("Have a great day!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        newscan.close();
    }

    static BankAccount find(BankAccount[] accs, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (accs[i].name.equalsIgnoreCase(name))
                return accs[i];
        }
        return null;
    }
}
