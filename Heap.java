import java.util.Arrays;


public class Heap {
	static void extractMax(int []a)
	{
		int max= a[0];
		a[0] = a[a.length-1];
		a[a.length-1] = Integer.MIN_VALUE;
		heapify(a,0);
		
	}
	static void heapify(int [] a, int i)
	{
		int lft = 2*i +1;
		int rt = 2*i+2;
		int grt = i;
		
		if(lft<a.length && max(a,lft,grt)>0) grt = lft;
		if(rt <a.length && max(a,rt,grt)>0) grt = rt;
		if(i!=grt)
		{
			int temp = a[i];
			a[i] = a[grt];
			a[grt] = temp;
			heapify(a,grt);
		}
	}
	
	private static int max(int[] a, int lft, int grt) {
		// TODO Auto-generated method stub
		if(a[lft]>a[grt])
		{
			return 1;
		}
		if(a[lft]<a[grt])
		{
			return -1;
		}
		else
		{
		return 1;
		}
	}

	public static void main(String[] args) {
		int [] a =  {5,6,9,8,3,4,7};
		int [] b = new int[a.length];
		for(int i = a.length/2;i>=0;i--)
		{
			heapify(a,i);
		}
		for(int i = 0;i<a.length;i++)
		{
			
		}
		extractMax(a);
		System.out.println(Arrays.toString(a));
	}
}
