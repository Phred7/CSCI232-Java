package labIV;

public class Main {

	public static void main(String[] args) {

		int aLength = 100000;
		
		Integer[] a = new Integer[aLength];
		Integer[] a2 = new Integer[aLength];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(100000);
			a2[i] = a[i];
		}

		StopWatch timer = new StopWatch();
		MergeSort.sort(a);
		System.out.println("Merge: " + timer.elapsedTime());
		timer = new StopWatch(); //reset timer to zero
		QuickSort.sort(a2);
		System.out.println("Quick " + ": " + timer.elapsedTime());
	}

}
