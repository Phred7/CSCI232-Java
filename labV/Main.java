package labV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import inClass.StopWatch;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		StackOfStrings sStack = new StackOfStrings();				
		File file = new File(args[0]);		
		Scanner scanner = new Scanner(file);

		while(scanner.hasNext()) {
			String string = scanner.next();
			sStack.push(string);
		}
		
		String[] strings = new String[sStack.size()];
		
		for (int i = sStack.size() - 1; i >= 0; i--) {			
			strings[i] = sStack.pop();
		}
		
		System.out.println("Words in " + args[0] + ": " + strings.length);
		StopWatch timer = new StopWatch();
		strings = (String[]) projectI.CocktailSort.cocktailSort(strings);
		System.out.println("Time to sort " + args[0] + ": " + timer.elapsedTime() + "seconds");

		int max = 0;
		file = new File(args[1]);
		scanner = new Scanner(file);
		
		while(scanner.hasNextFloat()) {
			float floati = scanner.nextFloat();
			max++;
		}
		
		scanner = new Scanner(file);
		
		Float[] floatis = new Float[max];
		for (int i = 0; i < floatis.length; i++) {
			floatis[i] = scanner.nextFloat();
		}
		
		System.out.println("Numbers in " + args[1] + ": " + floatis.length);
		timer = new StopWatch();
		floatis = (Float[]) projectI.CocktailSort.cocktailSort(floatis);
		System.out.println("Time to sort " + args[1] + ": " + timer.elapsedTime() + "seconds");

	}

}
