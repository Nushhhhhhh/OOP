package week3;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt user for a sentence
        System.out.print("Enter a sentence: ");
        String sentence = scan.nextLine();

        // Split sentence into words
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        // Reverse each word
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            reversedSentence.append(reversedWord.reverse()).append(" ");
        }

        // Print the output sentence with reversed words
        System.out.println("Reversed sentence: " + reversedSentence.toString().trim());

        scan.close(); // Close scanner
    }
}
