package projectI;

import java.util.Arrays;

public class CocktailSort {

	/**
	 * Method implementing the Cocktail sorting algorithm. This sort works by
	 * iterating through an array forwards and backwards checking adjacent elements
	 * to see if the left most element is greater than the one to the right, if so
	 * they swap positions. These exchanges continue until the array is passed over
	 * in one direction without any passes
	 * 
	 * @param a unsorted array of Comparable elements to be sorted
	 * @return sorted variation of this array a
	 */
	public static Comparable[] cocktailSort(Comparable[] a) {
		boolean sorted = false;

		while (!sorted) {
			sorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (less(a[i + 1], a[i])) {
					swap(a, i, i + 1);
					sorted = false;
				}
			}
			if (sorted == true) {
				break;
			}

			sorted = true;
			for (int j = a.length - 1; 0 < j; j--) {
				if (less(a[j], a[j - 1])) {
					swap(a, j, j - 1);
					sorted = false;
				}
			}
		}
		return a;
	}

	/**
	 * Takes in int array and two indexes and the element at index x with the
	 * element at index y
	 * 
	 * @param a int array
	 * @param x int index of an element in this int array a
	 * @param y int index of an element in this int array a
	 */
	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * Method that swaps the position of two given elements in an array
	 * 
	 * @param a an array of Comparables
	 * @param x position of the first element to be swapped
	 * @param y position of the second element to be swapped
	 */
	public static void swap(Comparable[] a, int x, int y) {
		Comparable temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * Method that compares v to w and determines which is less than the other if
	 * one is
	 * 
	 * @param v Comparable to compare to w
	 * @param w Comparable to compare to v
	 * @return boolean representation of which variable is less than the other if
	 *         one is
	 */
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * 
	 * @author Walker Ward
	 *
	 *         This class is used to test and debug Cocktail Sort's methods and
	 *         functionality
	 */
	public static class CocktailSortTesting {
		public static Comparable[] cocktailSort(Comparable[] a) {
			boolean sorted = false;
			int forward = 0;
			int reverse = 0;
			int loop = 0;
			System.out.println(Arrays.toString(a));
			while (!sorted) {
				sorted = true;
				for (int i = 0; i < a.length - 1; i++) {
					if (less(a[i], a[i + 1])) {
						swap(a, i, i + 1);
						forward++;
						sorted = false;
					}
				}
				if (sorted == true) {
					break;
				}

				sorted = true;
				for (int j = a.length - 1; 0 < j; j--) {
					if (less(a[j - 1], a[j])) {
						swap(a, j, j - 1);
						reverse++;
						sorted = false;
					}
				}
				loop++;
			}
			System.out.println(loop);
			System.out.println(forward);
			System.out.println(reverse);
			System.out.println(Arrays.toString(a));
			return a;
		}
	}
}