import java.util.Arrays;


public class TargetSumFinder {
	
	public static void main(String[] args) {
		int [] numberArray = {12,13,14,10,22,0};
		int targetSum = 22;
		
		Arrays.sort(numberArray);
		System.out.println(Arrays.toString(numberArray));
		for(int i=0;i<numberArray.length;i++)
		{
			int difference = targetSum-numberArray[i];
			if(difference < 0)
			{
				continue;
			}
			else
			{
				boolean result = binarySearch(numberArray,difference);
				System.out.println(result);
			}
		}
		
	}

	private static boolean  binarySearch(int[] numberArray, int difference) {
		
		int lo = 0;
        int hi = numberArray.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (difference < numberArray[mid]) hi = mid - 1;
            else if (difference > numberArray[mid]) lo = mid + 1;
            else return true;
        }
        return false;
	}

}
