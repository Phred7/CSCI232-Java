package projectI;

/**
 * 
 * @author Walker Ward
 *
 *         Class to sort an array of primitive integers by radix sort with
 *         counting sort as a subroutine
 * 
 *         Only functional for radicies inclusively between 2 and 10
 *
 */
public class RadixSort {

	/**
	 * Method that sorts an array of primitive integers in a given base (radix) and
	 * returns the sorted variation of this integer array This method rely's on
	 * CountingSort as a subroutine of radix sort
	 * 
	 * @param a     unsorted array of primitive integers in the proper base
	 * @param radix base of this number system between 2 and 10
	 * @return sorted variation of this primitive integer array a
	 */
	public static int[] radixSort(int[] a, int radix) {
		int max = max(a);
		int digMax = digits(max, radix);
		for (int i = 0; i < digMax; i++) {
			a = CountingSort.countSort(a, radix, i);
		}
		return a;
	}

	/**
	 * Calculates and returns the number of digits in a primitive integer
	 * 
	 * @param num the primitive integer to evaluate
	 * @param radix base of the number system being used
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

	/**
	 * 
	 * @author Walker Ward
	 *
	 *         This class is used to test and debug Radix Sort's methods and
	 *         functionality This class includes a test for a radix of 10 and a
	 *         radix of 2
	 */
	public static class RadixSortTesting {
		public static void radixCountingSortTest() {
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
				a = CountingSort.CountingSortTesting.countSort(a, radix, i);
			}
		}

		public static void binaryRadixCountingSortTest() {
			int radix = 2;
			int[] a = { 0, 111, 101, 100, 110, 10, 11, 1 }; // leave off standing zeros
			int max = max(a);
			int digMax = digits(max, radix);
			for (int j = 0; j < digMax; j++) {
				System.out.println("\nDigit: " + (j + 1));
				a = CountingSort.CountingSortTesting.countSort(a, radix, j);
			}
		}
	}
}