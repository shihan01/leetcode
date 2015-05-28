import java.util.ArrayList;
/*
 * We can firstly go horizontally and then go vertically.
 * But for the last element in the horizontal row, we can save it for next vertical column
 */
public class Spiral_order {
	
	public static ArrayList<Integer> spiral_order(int[][] matrix)
	{
		int horizontal_length = matrix[0].length;
		int vertical_height = matrix.length;
		ArrayList<Integer> res = new ArrayList<Integer>();
		int x=0, y=0;//crate the element positions
		while(horizontal_length>0 || vertical_height>0)
		{
			
			if(horizontal_length==1)//This is very important!!!!!
			{
				while(x<=vertical_height)
				{
					res.add(matrix[x][y]);
					System.out.print("fff");
					x=x+1;
				}
				break;
			}
			
			if(vertical_height==1)
			{
				while(y<=horizontal_length)
				{
					res.add(matrix[x][y]);
					y=y+1;
				}
			}
			
			if(vertical_height==1)
			{
				
			}
			for(int i=0; i<horizontal_length-1; i++)//go to the right
			{
				res.add(matrix[x][y]);
				y=y+1;
			}
			
			for(int i=0; i<vertical_height-1; i++)//go down
			{ 
				res.add(matrix[x][y]);
				x=x+1;
			}
			for(int i=0; i<horizontal_length-1; i++)//go left
			{
				res.add(matrix[x][y]);
				y=y-1;
			}
			for(int i=0; i<vertical_height-1; i++)//go up
			{ 
				res.add(matrix[x][y]);
				x=x-1;
			}
			//Then we have to shrink the horizontal_length and vertical_height by cutting off the head and tail
			horizontal_length = horizontal_length-2;
			vertical_height = vertical_height-2;
			//System.out.print(y);
			x=x+1;
			y=y+1;
		}
		return res;
	}
	//OK,let's test it
	public static void main(String[] args)
	{
		int[][] tester = {{1,2,3}, {4,5,6},{7,8,9}};
		ArrayList<Integer> res = spiral_order(tester);
		for(int each: res){
			System.out.print(""+each+"->");
		}
		
		System.out.print("\n");
		
		int[][] tester1 = {{1,2,3}, {4,5,6}};
		res = spiral_order(tester1);
		for(int each: res){
			System.out.print(""+each+"->");
		}
		
		System.out.print("\n");
		
		int[][] tester2 = {{1,2}, {3,4},{5,6}};
		res = spiral_order(tester2);
		for(int each: res){
			System.out.print(""+each+"->");
		}
	}
	

}
