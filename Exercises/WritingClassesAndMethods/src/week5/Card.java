package week5;

import java.util.Random;

class Deck {
    String suit;
    String faceValue;

    public Deck(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public void show() {
        System.out.println(faceValue + " of " + suit);
    }
}

public class Card {
    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faceValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        System.out.println("Dealing 5 random cards:");
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            String suit = suits[random.nextInt(suits.length)];
            String faceValue = faceValues[random.nextInt(faceValues.length)];
            Deck card = new Deck(suit, faceValue);
            card.show();
        }
    }
}
