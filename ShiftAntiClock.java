import java.util.Arrays;


public class ShiftAntiClock {
	
	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,6,7,8};
		
		for (int i = 0; i < 2; i++) {
			int temp =a[0],j;
			for (j= 0; j < a.length-1; j++) {
				//temp = a[j];
				a[j] = a[j+1];
			}
			a[j] = temp;
			
		}	
		System.out.println(Arrays.toString(a));
		}

}
