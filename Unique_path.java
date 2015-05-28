
public class Unique_path {
/*
 * Firstly, let's think about top down method, as the robot can only move left or go down each time. If they move to very left or very bottom, 
 * the robot would have one way to finish the the rest
 */
	public static int top_down(int row, int column)
	{
		if(row== 1)
		{
			return 1;
		}
		if(column == 1)
		{
			return 1;
		}
		return top_down(row-1, column) + top_down(row, column-1);
	}
/* 
 * We can also use the bottom up method. Firstly, we can assume there's only on column and three row b1, b2, b3
 * As there's only one column, wherever the row you're on, there's only one way to finish(this is our base!!!)
 * Now we add another column, for the first row b1, there's only one way to do this.
 * But for the b2, if it steps left it will go to the old b2. If it steps down, it will go to the b1.<Same for b3>
 * So the fomular is new b(n) = old b(n) + new b(n-1)
 */
	public static int bottom_up(int row, int column)
	{   
		//Firstly, loop through all those columns
		int [] columns = {1,1,1};
		for (int i=1;  i<column; i++)//Already got the base, loop starts from the second
		{
			//Then loop through all the rows
			for(int j=0; j<row; j++)
			{
				if(j==0)//our base!!! If it's the last row, no matter how many columns there are, there's only one way
				{
					columns[j]=1;
				}
				else
				{
					columns[j] = columns[j]+columns[j-1];
				}
			}
		}
		return columns[2];
	}
	//OK, let's test it
	public static void main (String[] args)
	{
		//Lets's have 3 rows and 7 columns, and it should return 28
		System.out.println("Top down method result: "+ top_down(3,7));
		System.out.println("Bottom up method result: "+ bottom_up(3,7));
	}

}
