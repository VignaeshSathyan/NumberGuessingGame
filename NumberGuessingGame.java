import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static int highScore = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.print("Enter the lower bound of the range: ");
            int lowerBound = scanner.nextInt();

            System.out.print("Enter the upper bound of the range: ");
            int upperBound = scanner.nextInt();

            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int numberOfGuesses = 0;
            boolean guessedCorrectly = false;

            System.out.println("I've picked a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfGuesses++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + numberOfGuesses + " guesses.");
                    guessedCorrectly = true;

                    if (numberOfGuesses < highScore) {
                        highScore = numberOfGuesses;
                        System.out.println("New high score! The best score so far is " + highScore + " guesses.");
                    } else {
                        System.out.println("The high score remains " + highScore + " guesses.");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing! The high score was " + highScore + " guesses.");
        scanner.close();
    }
}
