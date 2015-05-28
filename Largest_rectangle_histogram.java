/*
 * We can use the dynamic programming to solve this problem
 * We can use a stack to store the heights.
 * If the current height is larger than the previous, we just keep adding. Because, the every rectangle could be potentially bigger.
 * If the current is smaller than the previous, it means that the rectangle whose height is determined by the previous height couldn't be bigger
 * Thus, the sub problem is solved, like dynamic programming
 */
import java.util.*;
public class Largest_rectangle_histogram 
{
   //Let's create the class
   static class Wrap
   {
	   int height, index;
	   Wrap(int height, int index)
	   {
		   this.height = height;
		   this.index = index;
	   }
   }
  
   public static int largest_rectangle(int[] heights)
   {
	   int max_area = 0;
	   Stack<Wrap> stack = new Stack<Wrap>();
	   for (int i =0; i<heights.length; i++)
	   {
		   int index = i;
		   if(stack.isEmpty()){
			   stack.add(new Wrap(heights[i],i));
		   }
		   else
		   {
			   while(!stack.isEmpty() && stack.peek().height>heights[i])//while every element in the stack is bigger than current length, the stack would be empty!!!!
			   {
				   Wrap remove = stack.pop();
				   int temp_area = remove.height*(i-remove.index);//If we want to calculate the area, we need to know the index then we can know the width
				   max_area = Math.max(max_area,temp_area);//Updating the largest area
				   index = remove.index;//Important!!! This will consider the fact"The popped out height can contribute to area determined by its next small height
			   }
			   stack.add(new Wrap(heights[i],index));
		   }
	   }
	   while(!stack.isEmpty())
	   {
		   Wrap remove = stack.pop();
		   int temp_area = (heights.length-remove.index)*remove.height;
		   max_area = Math.max(max_area,temp_area);
	   }
	   
	   return max_area;
   }
   //OK, Let's test it
   public static void main(String[] args)
   {
	  int[] tester = {2,1,5,6,2,3};
	  int res = largest_rectangle(tester);//It should return 10;
	  System.out.println(res);
	  
	  int[] tester1 = {1,1,1,1,1,1};
	  res = largest_rectangle(tester1);//It should return 6;
	  System.out.println(res);
	  
	  int[] tester2 = {1,2,3,4,5,6};
	  res = largest_rectangle(tester2);//It should return 12;
	  System.out.println(res);
	  
	  int[] tester3 = {6,5,4,3,2,1};
	  res = largest_rectangle(tester3);//It should return 12;
	  System.out.println(res);
   }
}
