package projectI;

import java.util.Arrays;

import labIV.StopWatch;

/**
 * 
 * @author Walker Ward: x42f827
 * 
 *         This class runs each sorting algorithm and times them for CSCI 232 -
 *         Program I
 */
public class Main {

	public static void main(String[] args) {

		int len = 100000; // size of each Integer array

		Integer a[] = new Integer[len];
		Integer aBubble[] = new Integer[len];
		int aRadix[] = new int[len];
		Integer aCocktail[] = new Integer[len];

		for (int i = 0; i < a.length; i++) { // populates this int array a with random elements between 0 and 500000
			a[i] = StdRandom.uniform(500000);
		}

		for (int i = 0; i < a.length; i++) { // copies this int array a into all other arrays without using the Arrays class
			aBubble[i] = a[i];
			aRadix[i] = a[i];
			aCocktail[i] = a[i];
		}
		
		
		StopWatch timer = new StopWatch(); 
		aBubble = (Integer[]) BubbleSort.bubbleSortComp(aBubble);
		System.out.println("Bubble: " + timer.elapsedTime());
		
		timer = new StopWatch();
		aRadix = RadixSort.radixSort(aRadix, 10);
		System.out.println("Radix: " + timer.elapsedTime());

		timer = new StopWatch(); 
		aCocktail = (Integer[]) CocktailSort.cocktailSort(aCocktail); 
		System.out.println("Cocktail: " + timer.elapsedTime()); 
		
		boolean sortEquality = true;
		for (int i = 0; i < len; i++) {
			if(!(aRadix[i] == aBubble[i] && aBubble[i] == aCocktail[i])) {
				sortEquality = false;
				break;
			}
		}
		System.out.println("Sorts Equivalent? " + sortEquality);
	}
}