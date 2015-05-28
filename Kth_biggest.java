/*
 * We can firstly find the k/2th'biggest element's range to solve this problem
 */
public class Kth_biggest {
	
	public static int[] sublist(int[] input, int start, int end)
	{
		if(end-start==0)
		{
			return null;
		}
		int[] result = new int[end-start];
		int index=0;
		for(int i=start; i<end; i++)
		{
			result[index] = input[i];
			index++;
		}
		return result;
	}
	
	public static int find_element(int[]array1, int[]array2, int k)
	{
		if(array1 == null){
			return array2[k-1];
		}//Unlike python, there is no the length of list would equal 0 in java
		
		if(array1.length>array2.length)
		{
			return find_element(array2,array1,k);
		}
		
		if(k==1){
			return Math.min(array1[0], array2[0]);
		}
		
		int cut1 = Math.min(k/2, array1.length);
		int cut2 = k-cut1;
		
		if(array1[cut1-1]>array2[cut2-1])//this means array2[0:cut2] are before k, which we can be ignored
		{
			return find_element(array1,sublist(array2,cut2, array2.length),k-cut2);
		}
		
		if(array1[cut1-1]<array2[cut2-1])//this means array1[0:cut1] are before k, which can be ignored
		{
			return find_element(sublist(array1, cut1, array1.length), array2, k-cut1);
		}
		
		else{
			return array1[cut1];//this means array1[0:cut1] and array[0:cut2] are before k, and cut1+cut2 =k
		}
	}
	
	//OK, let's test it
	public static void main (String[] args)
	{
		int[] tester1 = {1,2,3,4,5,6,7};
		int[] tester2 ={1,2,3,8,9,10,11,12,13,14,15};
		int res = find_element(tester1,tester2,8);//It should return 5
		System.out.println(res);
		
	}

}
