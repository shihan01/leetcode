/*
 * We can have 2 index pointers for string1 and string2 respectively, if the characters at both positions are same or one of them is "?", we just keep on increasing the index
 * As we encounter "*", index2 should increase one and we keep track of this index in both string.
 * As we find out different single characters, we should let "*" represent a character,...then 2 characters...then3...
 * 
 */
public class Wild_matching {

	public static boolean is_match(String string1, String string2)
	{
		int s1=0;
		int s2=0;
		int star_index =-1;
		int match_index =0;
		while(s1<string1.length())
		{   //Keep in mind that as we increase the s2, it may exceed the range of string2!!!!
			if(s2<string2.length() && ((string1.charAt(s1)==string2.charAt(s2)) || string2.charAt(s2)=='?'))
			{
				s1 = s1+1;
				s2 = s2+1;
			}
			else if(s2<string2.length() && string2.charAt(s2)=='*')
			{
				match_index = s1;
				star_index = s2;
				s2 = s2+1;	
			}
			//Here's situation where different chars are met and "*" exists before them, "*" only works for characters that come after it!!!
			//But chars after "*" should still find its counterparts in string1
			//eg:novak and a*vak are different!!
			else if(star_index !=-1)
			{
				//As we discussed, let "*" represent 1 char firstly
				s1 = match_index+1;
				s2 = star_index+1;
				match_index = match_index+1;
			}
			else return false; //This is because chars that are before "*" didn't find their counterparts.
		
		}
		while(s2<string2.length())
		{
			if(string2.charAt(s2)=='*'){
				s2 = s2+1;
			}
			else return false;// This is because chars that are after "*" didn't find their counterparts.
		}
		
		return true;
	}
	
	//Let's test it
	public static void main (String[] args)
	{
		boolean res = is_match("aaghuhuj","a?*j");//true
		System.out.println(res);
	    res = is_match("aa","a?*j");//false
		System.out.println(res);
		res = is_match("aaghuhuj","a?*");//true
		System.out.println(res);
		res = is_match("aaghuhuj","a?bb*j");//false
		System.out.println(res);
	}
}
