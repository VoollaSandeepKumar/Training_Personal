

public class Snippet {
	
	
	public static long ipToLong(String ipAddress) {
	
	    long result = 0;
	
	    String[] ipAddressInArray = ipAddress.split("\\.");
	
	    for (int i = 3; i >= 0; i--) {
	
	        long ip = Long.parseLong(ipAddressInArray[3 - i]);
	
	        //left shifting 24,16,8,0 and bitwise OR
	
	        //1. 192 << 24
	        //1. 168 << 16
	        //1. 1   << 8
	        //1. 2   << 0
	        result |= ip << (i * 8);
	
	    }
	
	    return result;
	  }
	
	
	public static void main(String[] args)
	{
	long gw = ipToLong("150.0.0.0");
	System.out.println(gw);// i assume you converted the ip to a 32bit unsigned int
	int netmaskBits = 24; // in your example you had: /8, so this is 8
	
	// clear the right-most bits, leave only the leftmost 8 bits
	long netmask = (gw>>(32-netmaskBits))<<(32-netmaskBits); 
	System.out.println(netmask);
	
	long ip = ipToLong("151.2.2.2");
	System.out.println(ip);
	long maskedIp = (ip>>(32-netmaskBits))<<(32-netmaskBits);
	System.out.println(maskedIp);
	if (maskedIp == netmask) {System.out.println("allowed");}
	}
}