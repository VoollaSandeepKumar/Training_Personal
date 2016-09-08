
public class Binary1Counter {

	public static void main(String[] args) {
		int num = 8;
		int noOfOnes = binaryCounter(num);
		System.out.println(noOfOnes+"    no of ones in the binary");
	}

	private static int binaryCounter(int num) {
		int given_num= num;
		int count = 0;
			while(given_num !=0)
			{
				if(given_num % 2 == 1)
				{
					count++;
				}
				given_num = given_num/2;
				System.out.println(given_num);
			}
		return count;
	}
}
