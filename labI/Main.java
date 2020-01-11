package labI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Walker Ward
* 
*/

public class Main {

	public static void main(String[] args) {

		ArrayStack<Integer> stack = new ArrayStack<Integer>(100);
		RArrayStack<Integer> rStack = new RArrayStack<Integer>();
		
		ArrayStack<String> stackT = new ArrayStack<String>(100);
		RArrayStack<String> rStackT = new RArrayStack<String>();

		/**
		 * First stack with ArrayStack - Numbers
		 * 
		 * Takes in file from workspace directory
		 * Uses scanner to parse the file
		 * Pushes each integer onto this stack until the file has no more integers
		 * Pops each elem from this stack and prints them
		 * 
		 * If file is not found catches and error and prints file not found
		 */
		try {
			File inputF = new File(
					"C:\\Users\\Walker Ward\\Desktop\\All Work 18-19\\Code Resources\\Workspaces\\eclipse ide\\CSCI 232\\numbers.txt");
			Scanner reader = new Scanner(inputF);
			reader.useDelimiter("\n");
			while (reader.hasNext()) {
				int num = reader.nextInt();
				stack.push(num);

			}
			reader.close();

		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
		}

		System.out.println("Stack:");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println("\n\n\n");

		
		
		
		
		
		/**
		 * Stack Second - tinytale
		 * 
		 * Takes in file from directory
		 * Uses scanner to parse file until file is empty
		 * pushes each word onto this stack
		 * prints each element when popped
		 * 
		 * catches file not found exception
		 */
		try {
			File inputFT = new File(
					"C:\\Users\\Walker Ward\\Desktop\\All Work 18-19\\Code Resources\\Workspaces\\eclipse ide\\CSCI 232\\tinyTale.txt");
			Scanner readerT = new Scanner(inputFT);
			while (readerT.hasNext()) {
				String word = readerT.next();
				stackT.push(word);
			}
			readerT.close();

		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
		}

		System.out.println("Stack:");
		while (!stackT.isEmpty()) {
			System.out.println(stackT.pop());
		}
		System.out.println("\n\n\n");

		
		
		
		
		/**
		 * RStack first - numbers
		 * 
		 * Takes in file from dir
		 * Uses scanner to parse
		 * Pushes each integer until file is empty
		 * Prints and pops each elem at the same time
		 * 
		 * Catches file not found exception
		 */
		try {
			File inputF2 = new File(
					"C:\\Users\\Walker Ward\\Desktop\\All Work 18-19\\Code Resources\\Workspaces\\eclipse ide\\CSCI 232\\numbers.txt");
			Scanner reader2 = new Scanner(inputF2);
			while (reader2.hasNext()) {
				int num = reader2.nextInt();
				rStack.push(num);
			}
			reader2.close();

		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
		}

		System.out.println("RStack:");
		while (!rStack.isEmpty()) {
			System.out.println(rStack.pop());
		}
		System.out.println("\n\n\n");
		
		
		
		
		/**
		 * RStack Second - TinyTale
		 * 
		 * Reads in file for dir
		 * Uses scanner to parse
		 * pushes string word on from file until file is empty
		 * pops and prints elements when finished sequentially
		 * 
		 * catches file not found exception
		 */
		try {
			File inputFT2 = new File(
					"C:\\Users\\Walker Ward\\Desktop\\All Work 18-19\\Code Resources\\Workspaces\\eclipse ide\\CSCI 232\\tinyTale.txt");
			Scanner readerT2 = new Scanner(inputFT2);
			//readerT2.useDelimiter(" ");
			while (readerT2.hasNext()) {
				String word = readerT2.next();
				rStackT.push(word);
			}
			readerT2.close();

		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
		}

		System.out.println("RStack:");
		while (!rStackT.isEmpty()) {
			System.out.println(rStackT.pop());
		}
	}

}
