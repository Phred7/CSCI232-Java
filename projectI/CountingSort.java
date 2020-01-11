package projectI;

import java.util.Arrays;

public class CountingSort {

	/**
	 * Method that implements the Counting sort algorithm to sort an array of
	 * primitive integers that only include 1 digit with any radix/base inclusively
	 * between 2 and 10
	 * 
	 * @param a     unsorted primitive integer array with elements such that no
	 *              element has more that 1 digit
	 * @param radix the base of the number system to be used when sorting this
	 *              integer array
	 * @return sorted variation of this integer array a
	 */
	public static int[] countSort(int[] a, int radix) {
		int[] output = new int[a.length];
		int[] count = new int[radix];

		for (int i = 0; i < a.length; i++) {
			count[(a[i] % 10)]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = a.length - 1; 0 <= i; i--) {
			int j = --count[(a[i] % 10)];
			output[j] = a[i];
		}

		return output;
	}

	/**
	 * Method that implements the Counting Sort algorithm to sort a given digit of
	 * an array of primitive integers with any radix inclusively between 2 and 10
	 * 
	 * @param a     an unsorted primitive integer array to be sorted
	 * @param radix the base of the number system being used. Commonly this will be
	 *              10 (0-9) or 2 (binary)
	 * @param digit integer representation of the current digit being sorted. For a
	 *              single digit integer array set digit to 0
	 * @return
	 */
	public static int[] countSort(int[] a, int radix, int digit) {
		int divisor = (int) Math.pow(radix, digit);
		int[] output = new int[a.length];
		int[] count = new int[radix];

		for (int i = 0; i < a.length; i++) {
			count[((a[i] / divisor) % 10)]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = a.length - 1; 0 <= i; i--) {
			int j = --count[((a[i] / divisor) % 10)];
			output[j] = a[i];
		}

		return output;
	}

	/**
	 * Calculates and returns the number of digits in a primitive integer
	 * 
	 * @param num the primitive integer to evaluate
	 * @return the base 10 representation of this num's integer number of digits
	 */
	private static int digits(int num, int radix) {
		int digits = 0;
		while (num != 0) {
			num /= radix;
			digits++;
		}
		return digits;
	}

	/**
	 * This method locates the maximum primitive integer in an array a
	 * 
	 * @param a primitive integer array to evaluate
	 * @return the maximum integer in this array a
	 */
	private static int max(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		//CountingSortTesting.binaryRadixCountingSortTest();
		// CountingSortTesting.radixCountingSortTest();
	}

	/**
	 * 
	 * @author Walker Ward
	 *
	 *         This class is used to test/debug CountingSort's methods and
	 *         functionality This class also provides two examples of Radix-Counting
	 *         Sort with two different radicies
	 */
	@SuppressWarnings("unused")
	public static class CountingSortTesting {

		public static void radixCountingSortTest() {

			// Example of radix sort using counting sort
			int radix = 10;
			int[] a = { 43, 50, 1, 9, 11, 45, 91, 12, 21, 31, 81, 51, 20, 100, 127 };
			int max = max(a);
			int digMax = digits(max, radix);
			System.out.println("array lenth: " + a.length);
			System.out.println("max: " + max);
			System.out.println("max digits: " + digMax);
			// countSort(a, radix, 0);
			for (int i = 0; i < digMax; i++) {
				System.out.println("\nDigit: " + (i + 1));
				a = countSort(a, radix, i);
			}
		}

		public static void binaryRadixCountingSortTest() {
			int radix = 2;
			int[] a = { 0, 111, 101, 100, 110, 10, 11, 1 }; // leave off standing zeros
			int max = max(a);
			int digMax = digits(max, radix);
			for (int j = 0; j < digMax; j++) {
				System.out.println("\nDigit: " + (j + 1));
				a = CountingSortTesting.countSort(a, radix, j);
			}
		}

		public static int[] countSort(int[] a, int radix) {

			System.out.println("Unsorted: " + Arrays.toString(a));

			int[] output = new int[a.length];
			int[] count = new int[radix];

			for (int i = 0; i < a.length; i++) {
				count[(a[i] % radix)]++;
			}

			System.out.println("Number of Digits: " + Arrays.toString(count));

			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			System.out.println("Distributed Indecies " + Arrays.toString(count));

			for (int i = a.length - 1; 0 <= i; i--) {
				int j = --count[(a[i] % radix)];
				output[j] = a[i];
			}

			System.out.println("Sorted: " + Arrays.toString(output));

			return output;
		}

		/*
		 * Digit must start at 0
		 * 
		 */
		public static int[] countSort(int[] a, int radix, int digit) {

			System.out.println("Unsorted: " + Arrays.toString(a));

			int divisor = (int) Math.pow(radix, digit);
			System.out.println("Divisor: " + divisor);
			int[] output = new int[a.length];
			int[] count = new int[radix];

			for (int i = 0; i < a.length; i++) {
				count[((a[i] / divisor) % radix)]++;
			}

			System.out.println("Number of Digits: " + Arrays.toString(count));

			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			System.out.println("Distributed Indecies " + Arrays.toString(count));

			for (int i = a.length - 1; 0 <= i; i--) {
				int j = --count[((a[i] / divisor) % radix)];
				output[j] = a[i];
			}

			System.out.println("Sorted: " + Arrays.toString(output));

			return output;
		}

	}
}