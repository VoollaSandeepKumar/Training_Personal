
public class Xortest {

	public static void main(String[] args) {
		int [] temp1 = {1,1,2,3,2};
		int t = 0;
		//char [] temp1 = temp.toCharArray();
		for (int i = 0; i < temp1.length; i++) {
			t ^= temp1[i];
			//System.out.println(temp1[0]);
		}
		System.out.println(t);
	}
}
