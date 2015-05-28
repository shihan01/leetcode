/*In order to print out all the shortest path, we need to find right positions for words in dictionary, according to starting word
 * In order to find out the position which is shortest, we have to use BFS to do so
 * We can use a integer (level) to decide whether this path is shortest path or not
 */
import java.util.*;
public class Word_ladder2 
{
	//Firstly, let's define the wrap structure
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
	
	public static ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
	public static HashMap<String, ArrayList<String>> find_all_shortest_structure(String start_word, String end_word)
	{
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		//dict.add("hog");
		String[] characters = {"a", "b", "c", "d", "e", "f","g","h","i", "j"
                ,"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		Wrap first = new Wrap(start_word, 1);
		//We need to create a queue to do the BFS
		Queue<Wrap> queue = new LinkedList<Wrap>();
		queue.add(first);
		//we have to build a hash map to achieve the structure
		HashMap<String, ArrayList<String>> shortest_structure = new HashMap<String, ArrayList<String>>(); 
		//Implementing BFS
		int final_level = 9999999;
		while(!queue.isEmpty())
		{ 
			Wrap current = queue.poll();
			//if the level has already exceed the threshold we just return the structure
			if(current.level > final_level)
			{
			  return shortest_structure;	
			}
			for (String character : characters)
			{
				for (int i=0; i< current.word.length(); i++)
				{
					String temp = current.word.substring(0,i) + character + current.word.substring(i+1);
					//If we find the end word for the first time, we should set up the level threshold. Because there is no need to go further.
					if(temp.equals(end_word))
					{
						ArrayList<String> temp_array = new ArrayList<String>();
						if (shortest_structure.containsKey(current.word))
						{
							ArrayList<String> already_array = shortest_structure.get(current.word);
							for(String each : already_array)
							{
								temp_array.add(each);
							}	
						}
						temp_array.add(temp);
						shortest_structure.put(current.word, temp_array);
						final_level = current.level;
						continue;
					}
					//As for the temp word, if it is already some words' child word it should not go into the everything below
					//But the values in the structure are array lists not strings!!!(very important!!!), So we need to define a method to test whether those array contains temp word
					//If the keys of the structure already contain the word, it means that this word cannot be child word anymore.(Because we already found the path for this word)
					if(!contains_value(shortest_structure,temp) && !shortest_structure.containsKey(temp) )
					{
						if(dict.contains(temp))							
						{
							ArrayList<String> temp_array = new ArrayList<String>();
							if (shortest_structure.containsKey(current.word))
							{
								ArrayList<String> already_array = shortest_structure.get(current.word);
								for(String each : already_array)
								{
									temp_array.add(each);
								}
							}
							temp_array.add(temp);
							shortest_structure.put(current.word, temp_array);
							queue.add(new Wrap(temp, current.level+1));
						}
					}
				}
			}
			
		}
		
		return shortest_structure;
	}
	

	public static void start_paths(String start_word, String end_word )
	{
		HashMap<String, ArrayList<String>> shortest_structure = find_all_shortest_structure(start_word, end_word);
		ArrayList<String> path = new ArrayList<String>();
		//Let's print out the basic structure to find out the shortest path
		System.out.println("The shorted path structure: ");
		for(Map.Entry<String, ArrayList<String>> entry : shortest_structure.entrySet())
		{   
			
			String key = entry.getKey();
			System.out.print(key +": ");
			ArrayList<String> each_path = entry.getValue();
			for(String each: each_path)
			{
				System.out.print(each+",");	
			}
			System.out.print("\n");
		}
		
		get_paths(start_word, end_word, shortest_structure,path);
		
	}
	
	//This method is used to find out whether the structure already has the word
	public static boolean contains_value(HashMap<String, ArrayList<String>> map, String element)
	{
		for(ArrayList<String> each : map.values())
		{
			if(each.contains(element))
				return true;
		}
		return false;
		
	}
	
	//Recursively loop the structure by using DFS(we could also use BFS). If we find the ending word, we add the path to the public static paths
	public static void get_paths(String start_word, String end_word, HashMap<String, ArrayList<String>> structure, ArrayList<String> path)
	{
		if(start_word.equals(end_word))
		{
			path.add(start_word);
			paths.add(path);
			return;
		}
		if(!structure.containsKey(start_word))
		{
			return;
		}
		ArrayList<String> List = structure.get(start_word);
		path.add(start_word);		
		for(String each : List)
		{
			ArrayList<String> new_path = new ArrayList<String>();
			for(String every: path)
			{
				new_path.add(every);
			}
			get_paths(each, end_word, structure,  new_path);
		}
	}
	
	
	//Let's test it
	public static void main(String[] args)
	{
		start_paths("hit","cog");
		for(ArrayList<String> each_path: paths)
		{   
			System.out.print("The path:");
			for(String each: each_path)
			{
				System.out.print(each+"->");	
			}
			System.out.print("\n");
		}
		
		
	}
	
	
}
