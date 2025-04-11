package week3;

public class punctuation {
    public static void main(String[] args) {
        String text = "Mary had a little lamb, her fleece was as white as snow, and everywhere Mary went, " +
                      "the lamb was sure to go. -that was a nice poem- the end.";

        int punctuationCount = 0;

        // Iterate over each character in the string
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // Check if the character is a punctuation mark
            if (isPunctuation(ch)) {
                punctuationCount++;
            }
        }

        System.out.println("Total number of punctuation marks: " + punctuationCount);
    }

    // Method to determine if a character is a punctuation mark
    public static boolean isPunctuation(char ch) {
        String punctuations = ".,;:'\"!?-()[]{}";
        // Check if the character is in the string of punctuation marks
        return punctuations.indexOf(ch) != -1;
    }
}
