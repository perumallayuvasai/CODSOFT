import java.util.Random;
import java.util.Scanner;

public class Codsoft_taskno_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            boolean playAgain = true;
            int totalAttempts = 0;
            int totalRounds = 0;

            System.out.println("-------- Welcome to the Number Guessing Game --------");

            while (playAgain) {
                int attempts = 0;
                int secretNumber = random.nextInt(100) + 1;
                boolean guessedCorrectly = false;
                totalRounds++;

                System.out.println("\nRound " + totalRounds + ":");
                while (!guessedCorrectly && attempts < 10) {
                    System.out.print("Enter your guess (1-100): ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > secretNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        guessedCorrectly = true;
                        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + secretNumber);
                }

                totalAttempts += attempts;

                System.out.print("\nDo you want to play again? (yes/no): ");
                String playChoice = scanner.next().toLowerCase();
                playAgain = playChoice.equals("yes") || playChoice.equals("y");
            }

            System.out.println("\nThank you for playing!");
            System.out.println("Total rounds played: " + totalRounds);
            System.out.println("Average attempts per round: " + (totalAttempts / (double) totalRounds));
        }
    }
}
