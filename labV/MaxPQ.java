package labV;

public class MaxPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = 0;
		for (int i = 0; i < 0; i++) {
			j++;
			System.out.println(i * (i+1) + "---" + i*j);
		}
		
		System.out.println("\n");
		
		for (int i = 1; i < 20; i++) {
			//System.out.println("i:" + i + "   " + (i * (i+1)) % 3 + "---" + (i * (i+1)) % 6);
			System.out.println("a:" + i + "   " + (i * (i+1)) + "%3   " + (i * (i+1)) % 3);
					}
		
		System.out.println("\n");
		
		for(int i = 0; i < 0; i++) {
			for (int k = 1; k < 4; k++) {
				System.out.println("k:" + k + "   " + (i * (i+1)) % (3*k));
			}
			System.out.println();
		}
	}

}
