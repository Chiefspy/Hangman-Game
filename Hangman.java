import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Officer officer = new Officer();
		String response = "";
		
		while (!response.equals("0") && officer.numOfGuess > 0) {
			System.out.print("Please enter a letter or enter 0 to quit: ");
			response = scanner.nextLine();
			System.out.println(officer.numOfGuess);
			if (response.equals("0")) {
				break;
			}
			if (response.length() > 1) {
				System.out.println("Invalid input");
				continue;
			}
			response = response.toLowerCase();

			officer.AddGuess(response);
			System.out.println(officer.createHangedMan());
			System.out.println();
			System.out.println(addspace(officer.CurrentProgress()));
			for (int i = 0; i < officer.Words.length -1; i++) {
				System.out.print("_" + " ");
			}
			System.out.println("\n");
			System.out.println("Letters guessed incorrectly: " + officer.lettersGuessedIncorrectly);
			System.out.println("Number of guesses remaining: " + officer.numOfGuess);
			System.out.println("-----------------------------------------");
			if (officer.isWinner()) {
				System.out.println("You won");
				break;
			}else if (officer.numOfGuess == 0) {
				System.out.println("GAME OVER");
				System.out.println("Correct Word: " + officer.correctWord);
				break;
			}
			
		}
		System.out.println(officer.correctWord);
		System.out.println("Thanks for playing");

	
	}
	public static String addspace(String word) {
		String result = "";
		for(int i= 0; i < word.length(); i++) {
			result+= word.substring(i, i+1);
			result+= " ";
			
		}
		return result;
	}

}
