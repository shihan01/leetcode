/*
 * It's like the largest rectangle in histogram problem. We just need to each row and get a column for every elemnt in the row
 * Starting from the last row and for every element just go up and get the height
 */
import java.util.*;
public class Largest_rectangle_2d_array {
	
	public static int find_largest_rectangle_2d_array(int[][] matrix)
	{
		int max_area =0;
		//loop through every row
		for(int i=0; i<matrix.length; i++)
		{   
			int[] heights = new int [matrix[0].length];
			//scan every element in the row
			for(int j=0; j<matrix[0].length; j++)
			{
				//find the heights for each element
				heights[j] = find_height(i,j,matrix);	
			}
			//find the largest rectangle for this row
			int temp_area = find_largest_rectangle(heights);
			max_area  = Math.max(max_area, temp_area);
		}
		return max_area;
	}
	
	public static int find_height(int row, int column, int[][]matrix)
	{
		int res =0;
		for (int i = row; i<matrix.length; i++)
		{
			if(matrix[i][column]==0)
			{
				return res;
			}
			else
			{
				res = res+ matrix[i][column];
			}
		}
		return res;
	}
	
	//define the class Wrap
	static class Wrap
	{
		int value, index;
		Wrap(int value, int index)
		{
			this.value = value;
			this.index = index;
		}
	}
	
	public static int find_largest_rectangle(int[] heights)
	{
		Stack<Wrap> stack = new Stack<Wrap>();
		int max_area=0;
		for(int i =0; i<heights.length; i++)
		{
			int index = i;
			if(stack.isEmpty())
			{
				stack.push(new Wrap(heights[i],i));
			}
			else
			{
				while(!stack.isEmpty() && stack.peek().value>heights[i])
				{
					Wrap remove = stack.pop();
					int temp_area = remove.value*(i-remove.index);
					max_area = Math.max(max_area, temp_area);
					index = remove.index;
				}
				stack.push(new Wrap(heights[i],index));
			}
		}
		while(!stack.isEmpty())
		{
			Wrap remove = stack.pop();
			int temp_area = remove.value*(heights.length-remove.index);
			max_area = Math.max(temp_area, max_area);
		}
		return max_area;
	}
	//OK, Let's test it
	public static void main (String[] args)
	{
		int[][] tester = {{1,1,1,1},{0,1,1,0},{1,1,1,1}};//It should return 6
		for(int i =0; i<tester.length; i++){
			for(int j =0; j<tester[0].length; j++)
			{
				System.out.print(""+tester[i][j]+" ");
			}
			System.out.print("\n");
		}
		int res = find_largest_rectangle_2d_array(tester);
		System.out.println("The largest rectangle area is "+res);
		
		int[][] tester1 = {{1,1,1,},{0,1,1,},{1,1,0}};//It should return 4
		for(int i =0; i<tester1.length; i++){
			for(int j =0; j<tester1[0].length; j++)
			{
				System.out.print(""+tester1[i][j]+" ");
			}
			System.out.print("\n");
		}
		res = find_largest_rectangle_2d_array(tester1);
		System.out.print("The largest rectangle area is "+res);
	}

}
