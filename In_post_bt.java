/*As we know in post order, the root is always in the last element.
 * After getting the root, we can find the index of the root in the inorder list, thus those elements before it are left, and elements after it are right
 * Recursively calls this function, then we can get the 
 */
public class In_post_bt {
    //Firstly, let's create the binary class
	static class Node
	{
		int value;
		Node left;
		Node right;
	
		Node(int value)
		{
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		void inorder()
		{
			if(this.left!=null)
			{
				this.left.inorder();
			}
			System.out.print(""+this.value+"->");
			if(this.right!=null)
			{
				this.right.inorder();
			}
		}
		
		void postorder()
		{
			if(this.left!=null)
			{
				this.left.postorder();
			}

			if(this.right!=null)
			{
				this.right.postorder();
			}
			System.out.print(""+this.value+"->");
		}
		
		
	}
	//create the function of finding the index,Mmmmm....we don't need do this in Python!!!!
	public static int find_index(int[]input, int value)
	{
		for (int i =0; i<input.length; i++)
		{
			if(input[i]==value) return i;
		}
		return -1;
	}
	//create the function of finding the sub list,Mmmmm....we don't need do this in Python!!!!
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
	//let's create the function
	public static Node create_binary_tree(int[] inorder, int[] postorder)
	{
		if(inorder == null || postorder == null)//when inorder and postorder are nulls, we stop the recursion
		{
			return null;
		}
		int root_value = postorder[postorder.length-1];
		int root_index = find_index(inorder, root_value);
		Node root = new Node(root_value);
		root.left = create_binary_tree(sublist(inorder,0,root_index), sublist(postorder, 0,root_index));
		root.right = create_binary_tree(sublist(inorder, root_index+1, inorder.length),sublist(postorder,root_index,postorder.length-1));
		return root;
	}
	//OK, let's test it
	public static void main(String[] args)
	{
		int[] inorder = {4,2,5,1,6,3,7};
		int[] postorder = {4,5,2,6,7,3,1};
		Node res = create_binary_tree(inorder, postorder);
		res.inorder();
		System.out.print("\n");
		res.postorder();
		
	}
	
}
