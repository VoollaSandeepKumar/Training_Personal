import java.util.Arrays;


public class MergeSort {
	int [] a;
	int length;
	int [] temp;
	void sort(int [] b)
	{
		a = b;
		length = b.length;
		temp = new int [b.length];
		split(0,b.length-1);
		return;
	}
	void split(int l, int h)
	{
		if(l<h)
		{
			int mid = l+(h-l)/2;
			split(l,mid);
			split(mid+1,h);
			merge(l,mid,h);
		}
		return;
	}
	void merge(int l, int m, int h)
	{
		for (int i=l;i<=h;i++)
		{
			temp[i] = a[i];
		}
		int i = l;
		int j = m+1;
		int k = l;
		while(i<=m && j<=h )
		{
			if(temp[i] <= temp[j])
			{
				a[k] = temp[i];
				i++;
			}
			else{
				a[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i<= m)
		{
			a[k] = temp[i];
			k++;
			i++;
		}
		while(j<=h)
		{
			a[k] = temp[j];
			j++;
			k++;
		}
		return;
	}
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int [] a = {4,3,5,6,8};
		m.sort(a);
		System.out.println(Arrays.toString(m.a));
	}

}
