package extraCredit;

import java.util.Random;

public class ExtraCreditLab {
	
	/**
	 * Note:
	 * I created my own stack for extra practice using an array. I also set it to dynamically adjust the capacity of the array based on the size of the stack at any given time.
	 * 
	 */
	
	public static void main(String[] args) {
		ECStack<Integer> stackInts = new ECStack<>();
		Random rand = new Random();
		for(int i = 0; i < 20; i++) {
			stackInts.push(rand.nextInt(99) + 1);
		}
		System.out.println(stackInts.toString() + "\n" + stackInts.pop() + "\n" + stackInts.toString() + "\n" + "Searching for 50: " + stackInts.search(50) + "\nChecking Stack Status: " + stackInts.isEmpty());
		int[] ints = new int[stackInts.size()];
		int size = stackInts.size();
		int avg = 0;
		for(int i = 0; i < size; i++) {
			ints[i] = stackInts.pop();
			avg += ints[i];
		}
		System.out.println("Average of Stack Numbers: " + avg / size);
		
	}
}
