package de.asw.java.training2016.basics;

import java.util.Random;
import java.util.Scanner;

public class ZahlenRaten {

	public static void main(String[] args) throws Exception {

		Random random = new Random();

		int max = 100;
		int draw = random.nextInt(max);
		System.out.printf("I picked a random number between %s and %s (exclusive).%n", 0, max);
		System.out.println("Try to guess my number!");

		Scanner input = new Scanner(System.in);

		int trials = 0;

		while (true) {
			trials++;
			System.out.print("Your guess:> ");
			int guess = input.nextInt();

			if (guess == draw) {
				System.out.printf("Congratulations! You found: %s%n", guess);
				break;
			} else if (guess < draw) {
				System.out.println("Your number is too low...");
			} else {
				System.out.println("Your number is too high...");
			}
		}

		int maxIntelligentTrials = (int)Math.ceil(Math.log(max) / Math.log(2));
		System.out.printf("Max intelligent guesses: %s%n", maxIntelligentTrials);
		System.out.printf("Took you %s guesses%n", trials);

		if (trials <= maxIntelligentTrials) {
			System.out.println("Perfect!!");
		}
		System.out.println("Game over");
	}
}
