import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; // Maximum number of attempts allowed per round
        int attempts = 0;
        boolean playAgain = true;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("\nEnter your guess (attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    roundsWon++;
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();

            while (!playChoice.equals("yes") && !playChoice.equals("no")) {
                System.out.print("Please enter 'yes' or 'no': ");
                playChoice = scanner.next().toLowerCase();
            }

            if (playChoice.equals("no")) {
                playAgain = false;
            }
        }

        System.out.println("\nThank you for playing the Number Guessing Game!");
        System.out.println("You won " + roundsWon + " round(s).");
        
        scanner.close();
    }
}
