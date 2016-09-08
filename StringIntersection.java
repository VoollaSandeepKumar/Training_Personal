
public class StringIntersection {
	
	
	public static void main(String[] args) {
		
		String string1 ="sandeep";
		String string2 = "sep";
		char [] string1Array = string1.toCharArray();
		char [] string2Array = string2.toCharArray();
		
		int [] alphabetsOfString1 = new int [26];
		int [] alphabetsOfString2 = new int [26];
		int [] finalArray = new int [26];
		for(int i =0; i<string1Array.length;i++)
		{
			//System.out.println();
		   alphabetsOfString1[string1Array[i]- 97] ++;
			
		}
		for(int i =0; i<string2Array.length;i++)
		{
		   alphabetsOfString2[string2Array[i]- 97] ++;
			
		}
		
		for(int i =0;i<26;i++)
		{
			if(alphabetsOfString1[i]>0 && alphabetsOfString2[i]>0)
			{
				if(alphabetsOfString1[i]>alphabetsOfString2[i])
				{
					finalArray[i] = alphabetsOfString2[i];
				}
				else
				{
					finalArray[i] = alphabetsOfString1[i];
				}
			}
		}
		
		for(int i = 0;i<26;i++)
		{
			for(int j =0 ;j< finalArray[i];j++)
				
			{
				if(finalArray[i]>0)
				System.out.print((char)(i+97));
			}
		}

	}
}