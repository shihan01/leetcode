import java.util.*;
public class Nonrecursive_preorder 
{
	public static void nonrecursive(Tree root)
	{
		Tree current = root;
		Stack<Tree> stack = new Stack<Tree>();//use a stack to put all the right nodes
		while(!stack.isEmpty() || current != null)
		{
			if (current == null)//If left side is empty, we go to right side which are in the stack
				current = stack.pop();

			System.out.print(current.value);//We print out the value firstly
			if (current.right != null)
				stack.add(current.right);// If right node exits, put it in the stack
			current = current.left;
			
		}
		
	}
	
// Tree  1
//     2	3
//   4 5   6 7
	public static void main(String args[])
	{
		Tree tester = new Tree(1);
		tester.left = new Tree(2);
		tester.right = new Tree(3);
		tester.left.left = new Tree(4);
		tester.left.right = new Tree(5);
		tester.right.left = new Tree(6);
		tester.right.right = new Tree(7);
		
		System.out.print("Recursive: ");
		tester.recursive();
		System.out.print("\n");
		System.out.print("Nonrescursive: ");
		nonrecursive(tester);
		
	}

}

//Firstly, let's build the tree structure and use the recursive method
class 2Tree
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
	void recursive()
	{
		Tree current = this;
		System.out.print(current.value);
		if(current.left != null)
			current.left.recursive();//we cannot use "current = current.left", cause the current cannot change in next step
	
		if(current.right != null)
			current.right.recursive();
		  
	}
	
}
