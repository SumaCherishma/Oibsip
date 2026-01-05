import java.util.Random;
import java.util.Scanner;

public class NUMBERGUESSING {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		int totalScore = 0;
		boolean playAgain = true;

		System.out.println("🎯 Welcome to Guess the Number Game!");
		while (playAgain) {
			
			int numberToGuess = random.nextInt(100) + 1; // 1–100
		    int attemptsLeft = 7;
		    int attemptsUsed = 0;
		    boolean guessedCorrectly = false;
		    System.out.println("\nI have generated a number between 1 and 100.");
		    System.out.println("You have " + attemptsLeft + " attempts.");
		    while (attemptsLeft > 0) {
		    	System.out.print("Enter your guess: ");
		    int guess = sc.nextInt();
		    attemptsUsed++;
		    attemptsLeft--;
		    if (guess == numberToGuess) {
		    		System.out.println("✅ Correct! You guessed the number.");
		        guessedCorrectly = true;
		        break;
		        } else if (guess < numberToGuess) {
		        	System.out.println("📉 Too low!");
		        	} else {
		        		System.out.println("📈 Too high!");
		        		}
		    System.out.println("Attempts left: " + attemptsLeft);
		    }
		    if (guessedCorrectly) {
		    	int points = attemptsLeft * 10;
		    	totalScore += points;
		    	System.out.println("Points earned: " + points);
		    	} else {
		    		System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
		    		}
		    
		    System.out.println("Total Score: " + totalScore);
		    
		    System.out.print("\nDo you want to play another round? (yes/no): ");
		    sc.nextLine(); // clear buffer
		    String choice = sc.nextLine();

		    if (!choice.equalsIgnoreCase("yes")) {
		    	playAgain = false;
		    	}
		    }
		System.out.println("\n🎉 Game Over! Final Score: " + totalScore);
		sc.close();
		}
	}



