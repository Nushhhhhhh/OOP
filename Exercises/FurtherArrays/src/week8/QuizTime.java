package week8;

import java.util.Scanner;

class Question {
    String question, answer;

    Question(String q, String a) {
        question = q;
        answer = a;
    }
}

class Quiz {
    Question[] questions = new Question[25];
    int count = 0;

    void add(String q, String a) {
        if (count < 25) {
            questions[count++] = new Question(q, a);
        }
    }

    void giveQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < count; i++) {
            System.out.println("Q" + (i + 1) + ": " + questions[i].question);
            System.out.print("Answer: ");
            String ans = sc.nextLine();
            if (ans.equalsIgnoreCase(questions[i].answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong. Answer: " + questions[i].answer + "\n");
            }
        }

        System.out.println("Score: " + score + "/" + count);
        sc.close();
    }
}

public class QuizTime {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add simple questions
        quiz.add("What is the capital of Nepal?", "Kathmandu");
        quiz.add("2 + 2?", "4");
        quiz.add("What is the color of the sky?", "Blue");
        quiz.add("Which is the largest ocean?", "Pacific");
        quiz.add("The sun rises from?", "East");
        quiz.add("2 * 5?", "10");
        quiz.add("How many days in a week?", "7");
        quiz.add("Number of months in a year?", "12");
        quiz.add("What planet do we live on?", "Earth");
        quiz.add("Number of alphabets ?", "26");
        quiz.add("Number of planets in milkyway galaxy ?", "8");
        quiz.add("What is H2O?", "Water");
        quiz.add("What is the largest mammal?", "Blue Whale");
        quiz.add("Which shape has 3 sides?", "Triangle");
        quiz.add("What is the currency of USA called?", "Dollar");
        quiz.add("What is the name of our galaxy?", "MilkyWay");
        quiz.add("Is pluto a planet?", "No");
        quiz.add("Which is the largest dessert", "Sahara");
        quiz.add("A bird that can't fly", "Ostrich");
        quiz.add("Which is known as the tallest animal?", "Giraffe");
        quiz.add("How many continents?", "7");
        quiz.add("What do bees make?", "Honey");
        quiz.add("How many hours in a day?", "24");
        quiz.add("How many seconds in a minute?", "60");
        quiz.add("How many primary colors are there?", "3");

        
        // Run the quiz
        quiz.giveQuiz();
    }
}
