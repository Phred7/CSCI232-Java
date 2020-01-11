package labII;

import inClass.StopWatch;

/**
 * 
 * @author Walker Ward and Mike Heidal
 *
 * O(N^4)
 */
public class FourSum {
	
	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					for(int l = k+1; l < n; l++) {
						if(a[i] + a[j] + a[k] + a[l] == 0) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		RandNumGen rand = new RandNumGen();
		int[] ints = new int[1000];
		for(int i = 0; i < ints.length; i++) {
			ints[i] = rand.genRandSign(4000);
		}
		
		StopWatch timer = new StopWatch();
		int count = count(ints);
		System.out.println("elapsed time = " + timer.elapsedTime());
		System.out.println(count);
	}

}
