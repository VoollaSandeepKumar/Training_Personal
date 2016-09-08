import java.util.Arrays;



public class StringURLify {
	
	public static void main(String[] args) {
		String inputString = "   Sandeep    Ku  m ar   ";
		int count = 0;
		int newcount = 0;
		int newArraySize = 0;
		 char[] charArray = inputString.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(i<charArray.length -1)
			{
			if(charArray[i]  == ' ' && charArray[i+1] == ' ')
			{
				
			}
			else if (charArray[i] == ' ' && charArray[i+1] != ' ')
			{
				if(count == 0)
				{
					count++;
					newArraySize += 1;
				}
				else
				{
					newArraySize += 4;
				}
			}
			else if (charArray[i] != ' ' && charArray[i+1] == ' ')
			{
					//newArraySize += 1;
			}
			else
			{
					newArraySize += 1;
			}
			}
		}
		
		char[] newCharArray = new char[newArraySize];
		int j =0;
		for (int i = 0; i < charArray.length; i++) {

			if(i<charArray.length -1)
			{
			if(charArray[i]  == ' ' && charArray[i+1] == ' ')
			{
				
			}
			else if (charArray[i] == ' ' && charArray[i+1] != ' ')
			{
				if(newcount == 0)
				{
					newcount++;
					newCharArray[j] = charArray[i+1];
					j++;
				}
				else
				{
					newArraySize += 4;
					newCharArray[j] = '%';
					newCharArray[j+1] = '2';
					newCharArray[j+2] = '0';
					newCharArray[j+3] = charArray[i+1];
					j += 4;
					
				}
			}
			else if (charArray[i] != ' ' && charArray[i+1] == ' ')
			{
					//newArraySize += 1;
			}
			else
			{
				newCharArray[j] = charArray[i+1];
				j++;
			}
			}
		
		}
		System.out.println(Arrays.toString(newCharArray));
	}

}
