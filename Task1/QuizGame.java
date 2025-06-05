import java.util.Scanner;

public class QuizGame {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "Which language is used to write Android apps?",
            "Which symbol ends a statement in Java?",
            "What is 5 + 3?",
            "Which keyword is used to create a class in Java?",
            "What color is the sky on a clear day?"
        };

        String[][] options = {
            {"1. Java", "2. English", "3. Spanish", "4. French"},
            {"1. ,", "2. ;", "3. .", "4. :"},
            {"1. 7", "2. 8", "3. 5", "4. 9"},
            {"1. create", "2. class", "3. make", "4. object"},
            {"1. Green", "2. Red", "3. Blue", "4. Yellow"}
        };

        int[] answers = {1, 2, 2, 2, 3};

        int score = 0;

        System.out.println("Welcome to the Very Easy Coding Quiz!");
        System.out.println("Type the option number (1-4) for your answer.\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == answers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was option " + answers[i] + ".\n");
            }
        }

        System.out.println("Quiz complete! Your score: " + score + " out of " + questions.length);

        if (score == questions.length) {
            System.out.println("Awesome! You got all right!");
        } else {
            System.out.println("Keep trying, you will get better!");
        }

        scanner.close();
    }

}