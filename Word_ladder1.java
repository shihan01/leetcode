import java.util.*;
public class Word_ladder1 {
/* We have to find the shortest path, so we should implement BFS by using a queue to sort all the words in the dictionary.
 * In order to find out the shortest steps, we should add a level to all the words in the dictionary
 * So we need to define a structure that contains temporary word and its level
 */
	static class Wrap
	{   
		String word;
		int level;
		Wrap(String word, int level)
		{
			this.word = word;
			this.level = level;	
		}
		
	}
	
	public static int find_shortest_path(String start_word, String end_word)
	{
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		String[] characters = {"a", "b", "c", "d", "e", "f","g","h","i", "j"
                ,"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		//Then we need to define a hash set to determine whether word has met or not
		HashSet<String> met = new HashSet<String>();
		int level=0;
		Wrap first = new Wrap(start_word, level);
		//Implementing BFS, by using a queue to store all potential words
		Queue<Wrap> queue = new LinkedList<Wrap>();
		queue.add(first);
		while(!queue.isEmpty())
		{
			Wrap current = queue.poll();
			for (String character :characters)
			{ 
				for(int i=0; i<current.word.length(); i++)
				{   //find all possible words that it can change into
					String temp = current.word.substring(0,i) + character+ current.word.substring(i+1);
					//If we already find the ending word
					if(temp.equals(end_word))
					{
						return current.level+1;
						
					}
					//If the temporary word already has bee found
					if(met.contains(temp))
						continue;
					else//If our dictionary contains this word, we put in the queue and increase the level
					{
						if(dict.contains(temp))
						{   //Everytime we add new wrap into the queue, remember to increase the level!
							queue.add(new Wrap(temp,current.level+1));	
						}
						
					}
					
				}
				
			}
			
		}
		
		//If there is no matching words, we just return 0;
		return 0;
	}
	//Let's test it
	public static void main(String agrs[])
	{
	   int res = find_shortest_path("hit","hog");
	   System.out.print(res);
		
	}
	

}
