import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class RemoveDup {

	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap(); 
		int [] input = {1,2,3,4,4,4,5,6,6,6,7};
		int j =0;
		for (int i = 0; i < input.length -1; i++) {
			if(input[i] == input[i+1])
			{
				
			}
			else
			{
				j++;
				input[j] = input[i+1];
			}
		}
		for (int i =0;i<j;i++)
		{
			System.out.println(input[i]);
		}
	}
}
