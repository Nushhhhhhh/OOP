package week4;
import java.util.Scanner;
import java.util.Random;

public class Pin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter a 4-digit pin number to encrypt: ");
        int pin = scanner.nextInt();

        String pinHex = Integer.toHexString(pin);

        int rand1 = 1000 + random.nextInt(65535 - 1000);
        int rand2 = 1000 + random.nextInt(65535 - 1000);

        String randHex1 = Integer.toHexString(rand1);
        String randHex2 = Integer.toHexString(rand2);

        String encryptedPin = randHex1 + randHex2 + pinHex;

        System.out.println("Your encrypted pin number is " + encryptedPin + ".");

        scanner.close();
    }
}
