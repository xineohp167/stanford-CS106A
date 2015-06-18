/*
 * File: Roulette.java
 * -------------------
 * This program simulates a small part of the casino game of
 * roulette.
 */

import acm.program.*;
import acm.util.*;

public class Roulette extends ConsoleProgram {

	/** Amount of cash with which the player starts */
	private static final int STARTING_MONEY = 100;
	/** Amount wagered in each game */
	private static final int WAGER_AMOUNT = 10;

	/** Runs the program */

	public void run() {

		rgen.setSeed(1);
		giveInstructions();
		playRoulette();
	}

	/**
	 * Plays roulette until the user runs out of money.
	 */
	private void playRoulette() {

		int money = STARTING_MONEY;
		while (money > 0) {
			println("You now have $" + money + ".");
			String bet = readLine("Enter betting category: ");
			int outcome = spinRouletteWheel();
			if (isWinningCategory(outcome, bet)) {
				println("That number is " + bet + " so you win.");
				money += WAGER_AMOUNT;
			} else {
				println("That number is not " + bet + " so you lose.");
				money -= WAGER_AMOUNT;
			}
		}
		println("You ran out of money.");
	}

	/**
	 * Simulates the spinning of the roulette wheel. The method returns the
	 * number of the slot into which the ball fell.
	 */
	private int spinRouletteWheel() {
		int spin = rgen.nextInt(0, 36);
		println("The ball lands in " + spin + ".");
		return spin;
	}

	/*
	 * Returns true if the outcome matches the category specified by bet. If the
	 * player chooses an illegal betting category, this function always returns
	 * false.
	 */

	private boolean isWinningCategory(int outcome, String bet) {
		if (bet.equalsIgnoreCase("odd")) {
			return outcome % 2 == 1;
		} else if (bet.equalsIgnoreCase("even") && outcome != 0) {
			return (outcome % 2 == 0);
		} else if (bet.equalsIgnoreCase("low")) {
			return (1 <= outcome && outcome <= 18);
		} else if (bet.equalsIgnoreCase("high")) {
			return (19 <= outcome && outcome <= 36);
		} else {
			return (false);
		}
	}

	/**
	 * Welcomes the player to the game and gives instructions on the rules of
	 * roulette.
	 */
	private void giveInstructions() {
		println("Welcome to the roulette table!");
		println("Roulette is played with a large wheel divided into");
		println("compartments numbered from 0 to 36. Each player");
		println("places bets on a playing field marked with the");
		println("numbers and various categories. In this game,");
		println("the only legal bets are the following categories:");
		println("odd, even, low, or high. Note that 0 is not in any");
		println("category. After the bet is placed, the wheel is");
		println("spun, and a marble is dropped inside, which bounces");
		println("around until it lands in a compartment. If the");
		println("compartment matches the betting category you chose,");
		println("you win back your wager plus an equal amount. If");
		println("not, you lose your wager.");
	}

	/* Private instance variables */
	private RandomGenerator rgen = new RandomGenerator();
}