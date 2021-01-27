

public class HangMan {

		 private String[] hangmanPics = {"+---+\n"
				+ "  |   |\n"
				+ "      |\n"
				+ "      |\n"
				+ "      |\n"
				+ "      |\n"
				+ "=========", " +---+\n"
						+ "  |   |\n"
						+ "  O   |\n"
						+ "      |\n"
						+ "      |\n"
						+ "      |\n"
						+ "=========", " +---+\n"
								+ "  |   |\n"
								+ "  O   |\n"
								+ "  |   |\n"
								+ "      |\n"
								+ "      |\n"
								+ "=========", "+---+\n"
										+ "  |   |\n"
										+ "  O   |\n"
										+ " /|   |\n"
										+ "      |\n"
										+ "      |\n"
										+ "=========", " +---+\n"
												+ "  |   |\n"
												+ "  O   |\n"
												+ " /|\\ |\n"
												+ "      |\n"
												+ "      |\n"
												+ "=========", "+---+\n"
														+ "  |   |\n"
														+ "  O   |\n"
														+ " /|\\  |\n"
														+ " /    |\n"
														+ "      |\n"
														+ "=========", " +---+\n"
																+ "  |   |\n"
																+ "  O   |\n"
																+ " /|\\  |\n"
																+ " / \\  |\n"
																+ "      |\n"
																+ "========="};

		public String[] getHangmanPics() {
			return hangmanPics;
		}
		
		public String getHangman(int life) {
			return hangmanPics[life];
		}
}
