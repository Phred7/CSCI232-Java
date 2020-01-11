package testingClasses;

import java.util.Random;

public class CoinFlip {
	
	public static void coinFlip() {
		Random rand = new Random();
		int face  = rand.nextInt(1000);
		face = Math.abs(face);
		face = face % 2;
		if(face == 1) {
			System.out.println("Heads: Tell her");
		}else {
			System.out.println("Tails: Don't");
		}
	}

	public static void main(String[] args) {
		coinFlip();
	}

}
