/*
 * We can find all the "O" that are collected, and changed them in to"$", then change the rest "O"s into "X"
 * We can start from the four sides of the board, and check its four directions. If these "O"s are connected, they are not surrounded by "X"
 * We can achieve by using DFS or BFS
 * I'll use BFS to do this, and the queue should store the locations of each "O";
 */
import java.util.*;
public class Surrounded_regions
{
	//Firstly, let's define a class for the queue to store all the locations
	static class Location
	{
		int x;
		int y;
		Location(int x, int y)
		{
			this.x = x;
			this.y = y;
			
		}
	}
	
	public static String[][] change_connected(String[][] board)
	{
		//We have to create a hash set to determine this location has been met or not
		HashSet<Location> met = new HashSet<Location>();
		Queue<Location> queue = new LinkedList<Location>();
		for(int i =0; i<board[1].length;i++)
		{
			if(board[0][i].equals("O"))
			{
				Location temp = new Location(0,i);
				queue.add(temp);
				met.add(temp);
			}
			if(board[board.length-1][i].equals("O"))
			{
				Location temp = new Location(board.length-1,i);
				queue.add(temp);
				met.add(temp);
			}
		}
		
		for(int i =1; i<board.length-1;i++)
		{
			if(board[i][0].equals("O"))
			{
				Location temp = new Location(i,0);
				queue.add(temp);
				met.add(temp);
			}
			if(board[i][board[0].length-1].equals("O"))
			{
				Location temp = new Location(i,board[0].length-1);
				queue.add(temp);
				met.add(temp);
			}
		}
		
		while(!queue.isEmpty())
		{
			Location current = queue.poll();
			board[current.x][current.y]="$";
			//go up
			if(current.x-1>0 && !met.contains(new Location(current.x-1, current.y)))
			{
				if(board[current.x-1][current.y].equals("O"))//Because the index may out of range, we must check it here
				{
					Location temp = new Location(current.x-1,current.y);
					queue.add(temp);
					met.add(temp);
				}
			}
			//go down
			if(current.x+1<board.length && !met.contains(new Location(current.x+1, current.y)))
			{
				if(board[current.x+1][current.y].equals("O"))
				{
					Location temp = new Location(current.x+1,current.y);
					queue.add(temp);
					met.add(temp);
				}
				
			}
			//go left
			if(current.y-1<board[0].length && !met.contains(new Location(current.x, current.y-1)))
			{
				if(board[current.x][current.y-1].equals("O"))
				{
					Location temp = new Location(current.x, current.y-1);
					queue.add(temp);
					met.add(temp);
				}
			}
			//go right
			if(current.y-1<board[0].length && !met.contains(new Location(current.x, current.y+1)))
			{
				if(board[current.x][current.y+1].equals("O"))
				{
					Location temp = new Location(current.x, current.y+1);
					queue.add(temp);
					met.add(temp);
				}
			}
		}
		
		for (int i =0; i<board.length; i++)
		{
			for(int j=0; j<board[0].length; j++)
			{
				if(board[i][j] == "O")
				{
					board[i][j] = "X";
				}
				if(board[i][j] == "$")
				{
					board[i][j] = "O";
				}
			}
		}
		
		return board;
		
	}
	//OK, let's test this 
	public static void main(String args[])
	{
		String[][] tester = {{"X","X","O","X"},{"X","O","O","X"}, {"X","X","O","X"},{"X","O","X","X"}};
		
		System.out.println("The original board:");
		for(int i=0; i<tester.length; i++)
		{
			for (int j=0; j<tester[0].length; j++)
			{
				System.out.print(tester[i][j]);
			}
			
			System.out.println("");
		}
		
		
		String[][] res = change_connected(tester);
		System.out.println("The new board: ");
		for(int i=0; i<res.length; i++)
		{
			for (int j=0; j<res[0].length; j++)
			{
				System.out.print(res[i][j]);
			}
			
			System.out.println("");
		}
	}
	
}
