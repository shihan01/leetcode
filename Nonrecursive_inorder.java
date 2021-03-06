import java.util.*;
public class Nonrecursive_inorder 
{

	
	public static void recursive(Tree root)//Firstly, let's use recursive method
	{
		if(root.left != null)
		{
			recursive(root.left);
		}
		System.out.print(root.value);
		if(root.right != null)
		{
			recursive(root.right);
		}
		
	}
	
	public static void nonrecursive(Tree root)
	{
	  Stack<Tree> stack = new Stack<Tree>();//Define a stack to put all the nodes
	  Tree current;
	  current = root;
	  while(!stack.isEmpty() || current != null)//while current node  has value or stack is not empty, we put all the left tree node in
	  {
		  if(current == null)// while the current node is empty, we pop out the previous one and go to its right
		  {
			  current = stack.pop();
			  System.out.print(current.value);
			  current = current.right;    
		  }
		  else// don't forget "else", otherwise we might put null into the stack
		  {
		  stack.add(current);
		  current = current.left;
		  }
	  }
	   
	}  
	
	//Let's test it
   // Tree   1
  //       2   3
 //      4  5 6  7

	public static void main (String args[])
	{ 
		Tree tester = new Tree(1);
		tester.left = new Tree(2);
		tester.right = new Tree(3);
		tester.left.left = new Tree (4);
		tester.left.right = new Tree(5);
		tester.right.left = new Tree(6);
		tester.right.right =new Tree(7);
		
		System.out.print("Recursive: ");
		recursive(tester);
		System.out.print("\n");
		System.out.print("Non-recusrvie: ");
		nonrecursive(tester);
		
	}
}
class Tree
{ 
	int value;
	Tree left;
	Tree right;
	Tree(int value)
	{
		this.value = value;
		this.left = null;
		this.right = null;
	}
}


	


