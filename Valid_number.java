/*
 * As for a valid number, we know that there's only one decimal point, so we might define a static boolean to determine whether the decimal point appeared
 * There may be a letter "e", but "e" can only appear once, so we can split string into two parts and do the verification
 */
public class Valid_number {
	
	//Firstly, let's define a function to get rid of blank spaces in the start and in the end
	//We have to specify a boolean variable to determine whether a decimal point has met or not
	public static boolean met_decimal;
	public static String trim(String input)
	{
		met_decimal = true;
		int start = 0;
		int end = input.length()-1;
		while(start<input.length() && input.substring(start,start+1).equals(" "))
			start = start +1;
		while(end>start && input.substring(end).equals(" "))
			end = end-1;
		return input.substring(start,end+1);
		
	}
	
	//Secondly, let's split the string at "e" and check it's left and right
	public static boolean if_numeric(String input, int start)
	{
		for(int i= 0; i< input.length(); i++)
		{
			if(input.substring(i,i+1).equals("e"))
			{
				String left = input.substring(start,i);
				boolean result = verification(left);
				start = i+1;
				if(result) continue;
				else return false;	
			}
		}
		//This is the situation that e is on the last position of the input string
		if(start == input.length()){
			return true;
		}
		else
		{
			boolean result = verification(input.substring(start));
			return result;
		}
	}
	
	
	
	public static boolean verification(String input)
	{
		for (int i =0; i<input.length(); i++ )
		{
			if(input.substring(i, i+1).equals(".") && met_decimal)
			{
				met_decimal = false;
				continue;
			}
			if(input.substring(i, i+1).equals(".") && !met_decimal)
				return false;
			if((int) input.substring(i,i+1).charAt(0)> (int) "9".charAt(0) || (int) input.substring(i,i+1).charAt(0)< (int) "0".charAt(0))
			{
				return false;
			}
		}
		return true;
	}
	//OK, let's test it
	public static void main (String[] args)
	{
	   String[]	tester = {"0", " 0.1 ","abc","1 a", "2e10","0.1.1","12e.1e"};
	   for (String each : tester)
	   {
		   System.out.print(each);
		   System.out.print("=>");
		   System.out.println(if_numeric(trim(each),0));
	   }
	}

}
