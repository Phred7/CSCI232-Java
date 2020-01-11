package projectI;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * Sorts this int array a using Bubble sort; Checks each adjacent element with
	 * the current and swaps them if the first is smaller than the first Must make
	 * one pass without swapping any elements to ensure it is sorted
	 * 
	 * @param a int array of random elements
	 * @return bubble sorted version of this int array a
	 */
	public static int[] bubbleSort(int[] a) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					sorted = false;
				}
			}
		}
		return a;
	}

	/**
	 * Sorts this comparable array a using Bubble sort; Checks each adjacent element
	 * with the current and swaps them if the first is comparably less than the
	 * first Must make one pass without swapping any elements to ensure it is sorted
	 * 
	 * @param a comparable array of random elements
	 * @return bubble sorted version of this comparable array a
	 */
	public static Comparable[] bubbleSortComp(Comparable[] a) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < a.length - 1; i++) {
				if (less(a[i + 1], a[i])) {
					swap(a, i, i + 1);
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
	 *         This class is used to test and debug BubbleSort's methods and
	 *         functionality
	 */
	@SuppressWarnings("unused")
	public static class BubbleSortTesting {

		public static int[] bubbleSortTests(int[] a) {
			int sorts = 10; // used to see if the array has swapped elements on this pass
			int passes = 0;
			long accesses = 0;
			while (sorts != 0) {
				sorts = 0;
				int j = 1;
				for (int i = 0; i < a.length - 1; i++) {
					if (a[i] > a[j]) {
						swap(a, i, j);
						sorts++;
						accesses += 5;
					} else {
						accesses += 2;
					}
					j++;
				}
				passes++;
			}
			System.out.println("passes: " + passes);
			System.out.println("reads/writes: " + accesses);
			System.out.println(Arrays.toString(a));
			return a;
		}
	}
}