/*
 * It is same with spiral_order, we just need to put the element back in the matrix.
 * And also, shrink the n after a whole loop. Since it is a square, there is no need to specify the length and height
 */
public class Spiral_order2 {
	public static int[][] spiral_order_matrix(int n)
	{
		int[][] res = new int[n][n];
		int x=0, y=0;
		int value =1;
		while(n>0)
		{
		
			if(n==1){
				res[x][y]=value;
			}
		
			for(int i=0; i<n-1; i =i+1)
			{
				res[x][y] = value;
				value = value+1;
			    y=y+1;
			}
			for(int i=0; i<n-1; i =i+1)
			{
				res[x][y] = value;
				value = value+1;
			    x=x+1;
			}
			for(int i=0; i<n-1; i =i+1)
			{
				res[x][y] = value;
				value = value+1;
			    y=y-1;
			}
			for(int i=0; i<n-1; i =i+1)
			{
				res[x][y] = value;
				value = value+1;
			    x=x-1;
			}
			
			n=n-2;
			x=x+1;
			y=y+1;
		}
		
		return res;
	}
	
	//OK, let's test it
	public static void main (String[] args)
	{
		int[][] res = spiral_order_matrix(5);
		for(int i=0; i<res.length; i++)
		{
			for(int j=0;j<res[0].length;j++)
			{
				System.out.print(""+res[i][j]+",");
			}
			System.out.print("\n");
		}
	}
}
