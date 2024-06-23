package ankit;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        int gamesPlayed = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (gamesPlayed + 1));
            while (!guessedCorrectly && attempts < 10) { // Limiting attempts to 10 per round
                System.out.print("Enter your guess (between 1 and 100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalAttempts += attempts;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all 10 attempts. The correct number was " + numberToGuess + ".");
            }

            gamesPlayed++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! You played " + gamesPlayed + " round(s). Your total attempts were " + totalAttempts + ".");
        scanner.close();
    }
}
