
public class BitMaipulator {
	
	public static void main(String[] args) {
		
		int n = 13948;
		
		int c=n;
		int c0=0;
		int cl=0; 
		while(((c&1)==0)&&(c!=0)){
		c0++;
		c >>=1;
		}
		
		while ((c &1) == 1) {
			cl++;
			c >>=1;
		}
		
		
		if (c0+cl==31||c0+cl==0){
			//return -1;
		}
			int p = c0 + cl; // position of rightmost non-trailing zero 23
			n |= (1 << p); // Flip rightmost non-trailing zero
		    n &= ~((1 << p) - 1); // Clear all bits to the right of p
		    n |= (1 << (cl - 1)) - 1; // Insert (cl-1) ones onthe right
		
		System.out.println(n);
		//return 0;
	}

}
