import java.util.Scanner;
public class Game {

	//	function for displaying menu
	public static void showMenu() {
		//		======MENU======
			System.out.println("------\tHANGMAN\t------");
			System.out.println("");
			System.out.println("=======================");
			System.out.println("");
			System.out.println("MENU");
			System.out.println("");
			System.out.println("1. Start Game");
			System.out.println("");
			System.out.println("2. See Rules");
			System.out.println("");
			System.out.println("3. Exit the game");
			System.out.println("");
			System.out.println("Enter your selection:");
			System.out.println("");
	}
	
	// function for starting the game
	public static void startGame() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Starting the game");
		System.out.println("");
		
		System.out.println("Enter your name");
		//creating object for player
		Player p1 = new Player(sc.nextLine());
		//		sc.nextLine();
		System.out.println("Hello " + p1.getName() + ", welcome to HANGMAN GAME");
		System.out.println("");
		
		int categoryInput;

		do {
			showCategory();
			try{
				Scanner s = new Scanner(System.in);
				categoryInput = s.nextInt();
			}
			catch(Exception e) {
				categoryInput = -2;
			}
			String[] Level = {"Easy", "Medium", "Difficult"};
			boolean gameOver = false;
			String[] words;
			Category category = new Category();
			if(categoryInput == 1) {
				Pokemon p = new Pokemon();
				words = p.getWords();
				category = p;
				
			} else if(categoryInput == 2) {
				PizzaTopping p = new PizzaTopping();
				words = p.getWords();
				category = p;
				
			} else {
				System.out.println("Please choose correct option");
				continue;
			}
			System.out.println("You have choosen " + category.getCategoryName());
			System.out.println("");
			int changeCategory;
			do {
				System.out.println("To change your category press 0, to continue press 1");
				
				
				try{
					Scanner s = new Scanner(System.in);
					changeCategory = s.nextInt();
				}
				catch(Exception e) {
					changeCategory = -2;
				}
			}
			while(changeCategory != 1 && changeCategory != 0);
			
			if(changeCategory == 0) {
				System.out.println("Changing the category");
				System.out.println("");
			}
			else if(changeCategory == 1){
				for(int i = 0; i<Level.length; i++) {
					System.out.println("You are on " + Level[i] + " level!");
					System.out.println("");
					System.out.println("Your word is:");
					for(int j = 0; j < words[i].length(); j++) {
						if(words[i].charAt(j) == ' ') {
							System.out.print(' ');
						}
						else {
							System.out.print("_ ");
						}
					}
					
					//call function to check the letter
					int incorrectGuess = checkLetter(words[i].toLowerCase());
					if(incorrectGuess >= 6) {
						System.out.println("YOU LOOSE!!! GAME OVER!");
						gameOver = true;
						break;
					}
					
					System.out.println("");
				}
				if(gameOver != true) {
					System.out.println("YOU WIN!!");
				}
			}
			else {
				System.out.println("Please choose correct option");
				System.out.println("");
			}
		}while(categoryInput != -1);
	}
	
	
	//function for checking letter from the word
	public static int checkLetter(String word) {
		int incorrectGuess = 0;
		
		HangMan h1 = new HangMan();
		Scanner sc = new Scanner(System.in);
		int totalLetters = word.length(); 
		
		//creating an array to store the guessed letters entered by the user
		char[] printWord = new char[word.length()];

		//assigning "_" to the array of the length of the word
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == ' ') {
				printWord[i] = ' ';
			}
			else {
				printWord[i] = '_';
			}
		}
		
		while(totalLetters != 0) {
			System.out.println("\n\n" + h1.getHangman(incorrectGuess));
			System.out.println("\n");
			System.out.println("Enter letter");
			
			char userGuess = sc.next().charAt(0);
			
			System.out.println("Guess: " + userGuess);
			
			char[] wordInChar = new char[word.length()];
			
			//copying character by character of word into array
			for( int i = 0; i < word.length(); i++ ) {
				wordInChar[i] = word.charAt(i);
			}
			
			int count = 0;
			
			
			
			for(int i = 0; i< word.length(); i++) {
				
				if(Character.toLowerCase(userGuess) == wordInChar[i] && printWord[i] == '_') {
					printWord[i] = wordInChar[i];
					count++;
				}
				
				else if(printWord[i] == '_'){
					printWord[i] = '_';
				}
				
			}
			for (char c : printWord) { 
	            System.out.print(c + " "); 
	        } 
			if(count > 0) {
				System.out.println("");
				System.out.println("Your guess is correct  ✔");
			}
			else {
				System.out.println("Your guess is incorrect x");
				incorrectGuess ++;
				if(incorrectGuess >= 6) {
					
					break;
				}
			}
			totalLetters = totalLetters - count;
		}
		return incorrectGuess;
	}
	
	//function for displaying categories
	public static void showCategory() {
		//CATEGORIES
		System.out.println("Please choose a category:");
		System.out.println("");
		System.out.println("1. Pokemon");
		System.out.println("");
		System.out.println("2. Pizza Toppings");

	}
	
	//function for displaying the rules
	public static void showRules() {
		System.out.println("Listing the rules");
		System.out.println("");
		System.out.println("======RULES======");
		System.out.println("");
		System.out.println("--Hangman is a game for guessing the word with limited turns.");
		System.out.println("--Player needs to guess the word before the man gets hung.");
		System.out.println("--For every wrong guess, a part of the stick figure on the noose is added. ");
		System.out.println("--Once a full body is drawn, the game is over, and the player lost.");
		System.out.println("--The player gets to choose the category in which they want to play.");
		System.out.println("--There are three levels.");
		System.out.println("--For a player to win this game, they need to clear all the three levels without the man getting hung.");
		System.out.println("");
		//	Source: https://en.wikipedia.org/wiki/Hangman_(game)
		// used to get the definition of the hangman game
	}
	
	public static void main(String[] args) {
		
		
		int userSelection;
		
		//loop through the menu till user press 0
		do{
			showMenu();
			try{
				Scanner sc = new Scanner(System.in);
				userSelection = sc.nextInt();
			}
			catch(Exception e) {
				userSelection = -1;
				continue;
			}
			switch(userSelection) {
			
				case 1:
					//if user presses 1, game will start
						startGame();
					break;
				
				case 2:
					//if user presses 2, rules will be displayed
					showRules();
					break;
					
				case 3:
					//if user presses 3, the user will exit the game
					System.out.println("You have exited the game");
					System.out.println("");
					return;
				
				default:
					//if user, presses any other number other than the list, default will be displayed i.e. invalid number
					System.out.println("Please enter valid number");
					System.out.println("");
					break;
			}
			
		}while(userSelection != 0);
	}

}
