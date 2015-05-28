/*
 * It's obvious every level should be placed in the same array list, so we must include the level
 * There should be an array list which contains all the array lists.
 * When the size of the array list equals the level, it means it should add a new array list. Otherwise, we can get the array list(get(level)) and add the element
 */
import java.util.*;
public class Zigzag_level_order {
	static class Node
	{
		int value;
		Node left, right;
		
		Node(int value)
		{
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> Zigzag_order(Node root, int level)
	{
		if(level == res.size())
		{
			ArrayList<Integer> temp_res = new ArrayList<Integer>();
			temp_res.add(root.value);
			res.add(temp_res);	
		}
		else
		{
			res.get(level).add(root.value);
		}
		
		if(root.left != null)
		{
			Zigzag_order(root.left,level+1);
		}
		if(root.right != null)
		{
			Zigzag_order(root.right, level+1);
		}
		return res;
		
	}
	public static void main (String[] args)
	{
	//     1
   //   2    3
  //  4  5  6  7
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right =new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		ArrayList<ArrayList<Integer>> res = Zigzag_order(root,0);
		System.out.print("[ ");
		for(int i=0; i< res.size(); i++)
		{
			ArrayList<Integer> each =  res.get(i);
			if(i%2 != 0)
			{
				Collections.reverse(each);
			}
			System.out.print("[");
			for(Integer every: each )
			{
				System.out.print(""+every+",");
			}
			System.out.print("]");
		}
		System.out.print(" ]");
	  
	}

}
