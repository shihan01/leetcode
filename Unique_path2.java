
public class Unique_path2 {
/*
 * We can also use the top down method
 */
	public static int top_down(int[][] matrix, int row, int column)
	{
		if(matrix[row][column]==1)
		{
			return 0;//this way won't work
		}
		if(row==0)
		{
			return 1;
		}
		if(column==0)
		{
			return 1;
		}
		
		return top_down(matrix, row-1, column)+top_down(matrix, row, column-1);
	}
	
	public static int bottom_up(int[][] matrix, int row, int column)
	{
		//Like previous one, it consists the go left one and go up one
		//If the element do not equal to "-1". we can use our old formula, otherwise we have to adjust it 
		int[] columns = {1,1,1};
		int down, left;
		for (int i=1; i<column+1; i++)
		{
			for(int j=0;j<row+1; j++)
			{
				if(matrix[i][j]==1)//If the element equals 1, there's no way
				{
					columns[i]=0;
					continue;
				}
				if(j==0)
				{
					columns[i]=1;
				}
				else
				{
					if(matrix[i-1][j]==1)
						down = 0;
					else
						down = columns[i-1];
					if(matrix[i][j]==1)
						left=0;
					else
						left = columns[i];
					columns[i] =down+left;
					
				}
			}
		}
		return columns[2];
	}
	//OK, let's test it
	public static void main (String[] args)
	{
		int [][] tester = { {0,0,0}, {0,1,0}, {0,0,0}};
		//Lets's have 3 rows and 7 columns, and it should return 28
		System.out.println("Top down method result: "+ top_down(tester,2,2));
		System.out.println("Bottom up method result: "+ bottom_up(tester,2,2));
	}
}
