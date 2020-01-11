package projectI;

import java.util.Arrays;
import java.util.Random;

public class Sorts {

	public static void main(String[] args) {
		int len = 15;
		
		Integer a[] = new Integer[len];
		//Integer aBubble[] = new Integer[len];
		int aBubble[] =  new int[len];
		Integer aRadix[] = new Integer[len];
		Integer aCocktail[] = new Integer[len];
		
		for(int i = 0; i < a.length; i++) { //populates this int array a with random elements between 0 and 500000
			a[i] = StdRandom.uniform(50);
		}
		
		for(int i = 0; i < a.length; i++) { //copies this int array a into all other arrays without using the Arrays class
			aBubble[i] = a[i];
			aRadix[i] = a[i];
			aCocktail[i] = a[i];
		}
				
		String string1 = "aaa";
		String s2 = "aaaa";
		
		System.out.println(BubbleSort.less(s2, string1));
		System.out.println(s2.compareTo(string1));
		
		//StopWatch timer = new StopWatch();
		System.out.println(Arrays.toString(aBubble));
		aBubble = BubbleSort.BubbleSortTesting.bubbleSortTests(aBubble);
		System.out.println(Arrays.toString(aBubble));
		
		System.out.println("\n\n");
		
		System.out.println(Arrays.toString(aCocktail));
		aCocktail = (Integer[]) CocktailSort.cocktailSort(aCocktail);
		System.out.println(Arrays.toString(aCocktail));
		
		int x = 23;
		int radix = 10;
		int digit = 2;
		int value = 0;
		
		//value = (x % (int) Math.pow(radix, digit)) - ;
		System.out.println((x / 100) % 10);
		
		//System.out.println(timer.elapsedTime());
		/*int j = 0;
		int n = 91;
		int val = 0;
		//System.out.println((n/10)%10 + " " + n%10);
		//System.out.println(n%(Math.pow(10, j))); 
		//System.out.println(n/(Math.pow(10, j))); 
		//System.out.println((n/(Math.pow(10, j)))%10); 
		val = (int) (n/((Math.pow(10, j))) % 10);
		System.out.println(val);
		j++;
		//System.out.println(n%(Math.pow(10, j))); 
		//System.out.println((n/(Math.pow(10, j)))%10); 
		System.out.println((int) (n/((Math.pow(10, j))) % 10));
		j++;
		//System.out.println(n%(Math.pow(10, j))); 
		//System.out.println(n/(Math.pow(10, j))); 
		//System.out.println((n/(Math.pow(10, j)))%10); 
		System.out.println((int) (n/((Math.pow(10, j))) % 10));
		
		System.out.println(Arrays.toString(cocktailSort(aCocktail)));*/
	}
}
