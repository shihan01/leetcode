import java.util.*;


/*We find all the possible slopes, and use them as keys in a hash map. Two points that has the 
same slope is on the same line*/
public class Find_points 
{
	static class Points
	{
		int x;
		int y;
	 Points(int x, int y)
	 {
			this.x = x;
			this.y = y;
	 }
	}
	 public static double get_slope(Points p1, Points p2)
	 {
		 return (p2.y-p1.y)/(p2.x-p1.x);
	 }
	 
	 public static int points_on_sameline(Points[] points)
	 {    
		 int res = -1;
		 for (int i=0;i<points.length;i++)
		 {
			//Using a hash map to store all the slope
			 HashMap<String, Integer> map = new HashMap <String,Integer>();
			 map.put("infinity", 0);//Adding the slope "Infinity"
			 int same_points = 0;
			 //Two points can define a slope, next and previous points slope is already calculated in previous loop
			 for(int j=i+1; j<points.length;j++)
			 {   
				 //Firstly check whether those two points are same or not
				 if(points[i].x == points[j].x && points[i].y == points[j].y )
				 {
					 same_points +=1;
					 continue;	 
				 }
				 //Secondly check if those points are on the same vertical line
				 if(points[i].x == points[j].x)
				 {
					 if(map.get("infinity")==0)
					 {
						 map.put("infinity", 2); 
					 }
					 else
					 {
						 map.put("infinity", map.get("infinity")+1);
					 } 
			     
			     continue;//Do not forget this!!

				 }
				 //Thirdly get their slope and update
				 double slope = get_slope(points[i],points[j]);
				 if(map.containsKey(String.valueOf(slope)))
				 {
					 map.put(String.valueOf(slope), map.get(String.valueOf(slope))+1);
				 }else
				 {
					map.put(String.valueOf(slope), 2);
				 }
				 
				 res= Math.max(Collections.max(map.values())+same_points, res);
				 
			 }
			 
			 
		 }
		 return res;
	 }
	 
	 public static void main (String args[])
	 {
		 Points[] tester = new Points[6];
		 tester[0] = new Points(1,0);
		 tester[1] = new Points(1,0);
		 tester[2] = new Points(1,1);
		 tester[3] = new Points(2,2);
		 tester[4] = new Points(1,0);
		 tester[5] = new Points(4,9);
		 
		 int res = points_on_sameline(tester);
		 System.out.print(res);
		 
	 }
	 
	
}
	


