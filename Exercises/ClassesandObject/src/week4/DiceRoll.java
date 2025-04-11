package week4;

import java.util.Scanner;
import java.util.Random;

public class DiceRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How many sides does die 1 have? ");
        int Dice1 = scanner.nextInt();

        System.out.print("How many sides does die 2 have? ");
        int Dice2 = scanner.nextInt();

        int sum1 = 0, sum2 = 0;

        for (int i = 1; i <= 3; i++) {
            int roll1 = random.nextInt(Dice1) + 1;
            int roll2 = random.nextInt(Dice2) + 1;

            sum1 += roll1;
            sum2 += roll2;

            System.out.println("Die 1 " + ordinal(i) + " roll = " + roll1 + ".");
            System.out.println("Die 2 " + ordinal(i) + " roll = " + roll2 + ".");
        }

        double avg1 = sum1 / 3.0;
        double avg2 = sum2 / 3.0;

        System.out.println("Die 1 rolled a total of " + sum1 + " and rolled " + avg1 + " on average.");
        System.out.println("Die 2 rolled a total of " + sum2 + " and rolled " + avg2 + " on average.");

        scanner.close();
    }

    private static String ordinal(int number) {
        if (number == 1) return "first";
        if (number == 2) return "second";
        if (number == 3) return "third";
        return number + "th";
    }
}
