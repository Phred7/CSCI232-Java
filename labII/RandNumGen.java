package labII;

import java.util.Random;

public class RandNumGen {
	
	Random rand = new Random();
	
	public RandNumGen() {
		
	}
	
	public int genRand(int max) {
		return rand.nextInt(max);
	}
	
	public int genRandSign(int max) {
		int sign = rand.nextInt(2);
		if(sign == 0) {
			return -1 * rand.nextInt(max);
		}else {
			return rand.nextInt(max);
		}
		
	}
	
	

}
