import java.util.Arrays;


public class BubbleSort {
	public static void main(String[] args) {
		
		int [] a = {4,3,12,5,6};
		
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length-i; j++) {
				if(a[j]>a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
}
