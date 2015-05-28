
public class Rectangle implements Compare_rectangle
{
	
	int width;
	int length;
	
	public Rectangle(int width, int length)
	{
		this.width = width;
		this.length = length;
	}
	
	public int compare_area(Compare_rectangle other)
	{
		Rectangle other_rect = (Rectangle) other;
		int area1 = this.width*this.length;
		int area2 = other_rect.width * other_rect.length;
		return area1-area2;
	}
	
	public static Rectangle find_larger_rectangle(Rectangle first, Rectangle second)
	{
		Compare_rectangle first_rec = (Compare_rectangle) first;
		Compare_rectangle second_rec = (Compare_rectangle) second;
		if (first_rec.compare_area(second_rec)>0)
		   return first;
		else 
			return second;
	}


}
